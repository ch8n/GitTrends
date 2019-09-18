package dev.ch8n.gittrends.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

fun AppCompatImageView.loadImage(src: String) = Picasso.get()
    .load(src)
    .resize(120, 120)
    .centerCrop()
    .into(this)

fun String.toToast(context: Context) = Toast
    .makeText(context, this, Toast.LENGTH_SHORT)
    .show()

fun AppCompatImageView.loadAvatar(src: String) = Picasso.get()
    .load(src)
    .resize(120, 120)
    .transform(CropCircleTransformation())
    .centerCrop()
    .into(this)
