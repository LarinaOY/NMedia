package ru.netology.nmedia

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val post = getLoremPost()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        reRender(binding, post)

        binding.root.setOnClickListener {
            Log.d("Olga", "root onClick")
        }

        binding.likeImageButton.setOnClickListener {

            Log.d("Olga", "likeImageButton onClick")

            if (post.likedByMe) {
                binding.likeImageButton.setImageResource(R.drawable.ic_baseline_like_24)
                post.likes -= 1
            } else {
                binding.likeImageButton.setImageResource(R.drawable.ic_baseline_liked_24)
                post.likes += 1
            }

            post.likedByMe = !post.likedByMe
            reRender(binding, post)
        }

        binding.shareImageButton.setOnClickListener {

            Log.d("Olga", "shareImageButton onClick")

            post.shares += 1
            reRender(binding, post)
        }

        binding.viewsImageButton.setOnClickListener {

            Log.d("Olga", "viewsImageButton onClick")

            post.views += 1
            reRender(binding, post)
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
    }

}