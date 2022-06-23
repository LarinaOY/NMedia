package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.data.observe(this) {
            reRender(binding, it)
        }

        binding.likeImageButton.setOnClickListener {
            viewModel.onLikeClicked()
        }

        binding.shareImageButton.setOnClickListener {
            viewModel.onShareButtonClicked()
        }

        binding.viewsImageButton.setOnClickListener {
            viewModel.onViewButtonClicked()
        }

    }

    private fun reRender(binding: ActivityMainBinding, post: Post) {
        binding.avatar.setImageResource(post.avatar)
        binding.author.text = post.author
        binding.date.text = post.date
        binding.mainText.text = post.text
        binding.likesCounter.text = doCounterformat(post.likes)
        binding.sharesCounter.text = doCounterformat(post.shares)
        binding.viewsCounter.text = doCounterformat(post.views)

        if (post.likedByMe) {
            binding.likeImageButton.setImageResource(R.drawable.ic_baseline_liked_24)
        } else {
            binding.likeImageButton.setImageResource(R.drawable.ic_baseline_like_24)
        }

    }

}