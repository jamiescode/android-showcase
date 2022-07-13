package uk.co.jamiecruwys.showcase.presentation

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.di
import org.kodein.di.instance
import uk.co.jamiecruwys.showcase.databinding.MainFragmentBinding

class MainFragment : Fragment(), DIAware {

    companion object {
        fun newInstance() = MainFragment()
    }

    override val di: DI by di()

    private val viewModel: MainViewModel by instance()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val stateObserver = Observer<MainViewModel.State> {
        binding.progressBar.isVisible = it.isLoading
        binding.randomButton.isVisible = !it.isLoading
        it.imageUrl.let { url ->
            if (url.isEmpty()) {
                binding.image.setImageResource(android.R.color.transparent)
            } else {
                Glide.with(this).load(url).addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        viewModel.onImageLoaded(it)
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        viewModel.onImageLoaded(it)
                        return false
                    }

                }).into(binding.image)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stateLiveData.observe(viewLifecycleOwner, stateObserver)

        binding.randomButton.setOnClickListener {
            viewModel.onRandomButtonPressed()
        }

        viewModel.onRandomButtonPressed()
    }
}