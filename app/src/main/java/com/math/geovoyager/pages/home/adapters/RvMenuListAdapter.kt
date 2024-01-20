package com.math.geovoyager.pages.home.adapters

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.math.geovoyager.databinding.HomeMenuItemBinding
import com.math.geovoyager.pages.atp.ATPActivity
import com.math.geovoyager.pages.cp.CPActivity
import com.math.geovoyager.pages.home.models.MenuData
import com.math.geovoyager.pages.materials.MaterialsActivity
import com.math.geovoyager.pages.practicequestions.PracticeQuestionsActivity
import com.math.geovoyager.pages.preparequiz.PrepareQuizActivity
import com.math.geovoyager.pages.video.VideoActivity

class RvMenuListAdapter(private val context: Context, private val data: List<MenuData>) :
    RecyclerView.Adapter<RvMenuListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: HomeMenuItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView

        fun bind(data: MenuData) {
            with(binding) {
                menuImage.setImageResource(data.image)
                tvMenuName.text = data.name

                menuButton.setOnClickListener {
                    when (data.name) {
                        "ATP" -> {
                            val intent = Intent(context, ATPActivity::class.java)
                            context.startActivity(intent)
                        }

                        "CP" -> {
                            val intent = Intent(context, CPActivity::class.java)
                            context.startActivity(intent)
                        }

                        "Materi" -> {
                            val intent = Intent(context, MaterialsActivity::class.java)
                            context.startActivity(intent)
                        }

                        "Video" -> {
                            if (isInternetAvailable()) {
                                val intent = Intent(context, VideoActivity::class.java)
                                context.startActivity(intent)
                            } else {
                                Toast.makeText(
                                    context,
                                    "Tidak ada koneksi internet",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        "Latihan Soal" -> {
                            val intent = Intent(context, PracticeQuestionsActivity::class.java)
                            context.startActivity(intent)
                        }

                        "Quiz" -> {
                            val intent = Intent(context, PrepareQuizActivity::class.java)
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HomeMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            ?: false
    }
}