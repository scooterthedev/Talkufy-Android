@file:Suppress("SYNTHETIC_UNRESOLVED_WIDGET_TYPE")

package ca.scooter.talkufy.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bubble_image_left.view.*
import kotlinx.android.synthetic.main.bubble_image_right.view.*
import kotlinx.android.synthetic.main.bubble_left.view.*
import kotlinx.android.synthetic.main.bubble_map_left.view.*
import kotlinx.android.synthetic.main.bubble_map_right.view.*
import kotlinx.android.synthetic.main.bubble_right.view.*
import kotlinx.android.synthetic.main.bubble_video_left.view.*
import kotlinx.android.synthetic.main.bubble_video_right.view.*
import kotlinx.android.synthetic.main.text_header.view.*

object Holders {

    class TargetTextMsgHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val message = itemView.messageText_left!!
        val time = itemView.time_left!!
        val headerDateTime = itemView.header_left!!
        // val imageLayout = itemView.imageFrameLayout!!
        val container = itemView.container_left!!
        val messageLayout = itemView.message_layout_text_left!!
        val senderIcon = itemView.circle_sender_text!!
        val bubbleContainer = itemView.bubble_container_left_text!!
        val senderTitle = itemView.messageText_sender_left!!

    }
    class MyTextMsgHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val message = itemView.messageText_right!!
        val time = itemView.time_right!!
        val messageStatus = itemView.delivery_status!!
        val headerDateTime = itemView.header_right!!
        val container = itemView.container_right!!
        val messageLayout = itemView.message_layout_text_right!!
        val bubbleContainer = itemView.bubble_container_right_text!!


    }


    class MyImageMsgHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val message = itemView.messageText_image_right!!
        val time = itemView.time_image_right!!
        val imageView = itemView.imageview_image_right!!
        val progressBar = itemView.progress_bar_image_right!!
        val tapToRetry = itemView.tap_retry_image_right!!
        val messageStatus = itemView.delivery_image_status!!
        val headerDateTime = itemView.header_image_right!!
        val container = itemView.container_image_right!!

        val messageLayout = itemView.message_layout_image_right!!

        val cardContainer = itemView.image_container_right_card!!

        val imageUploadControl = itemView.imageview_image_control_right!!
    }

    class TargetImageMsgHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val message = itemView.messageText_image_left!!
        val time = itemView.time_image_left!!
        val imageView = itemView.imageview_image_left!!
        val headerDateTime = itemView.header_image_left!!
        // val imageLayout = itemView.imageFrameLayout!!
        val container = itemView.container_image_left!!

        val messageLayout = itemView.message_layout_image_left!!
        val senderIcon = itemView.circle_sender_image!!

        val cardContainer = itemView.image_container_left_card!!

        val senderTitle = itemView.messageText_sender_image_left!!

    }



    class MyVideoMsgHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val message = itemView.messageText_video_right!!
        val time = itemView.time_video_right!!
        val centerImageView = itemView.imageview_video_right!!
        val progressBar = itemView.progress_bar_video_right!!
        val tapToRetry = itemView.tap_retry_video_right!!
        val messageStatus = itemView.delivery_video_status!!
        val headerDateTime = itemView.header_video_right!!
        val videoLayout = itemView.videoFrameLayoutRight!!
        val thumbnail = itemView.thumbnail_right!!
        val videoLengthText = itemView.video_length_right!!

        val tap_to_download = itemView.tap_retry_download_video_right!!
        val container = itemView.container_video_right!!

        val messageLayout = itemView.message_layout_video_right!!

        val cardContainer = itemView.video_container_right_card!!



    }

    class TargetVideoMsgHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val message = itemView.messageText_video_left!!
        val time = itemView.time_video_left!!
        val centerImageView = itemView.imageview_video_left!!
        val headerDateTime = itemView.header_video_left!!
        val videoLayout = itemView.videoFrameLayoutLeft!!
        val thumbnail = itemView.thumbnail_left!!
        val progressBar = itemView.progress_bar_video_left!!
        val videoLengthText = itemView.video_length_left!!
        val tap_to_download = itemView.tap_retry_download_video_left!!
        val container = itemView.container_video_left!!

        val messageLayout = itemView.message_layout_video_left!!
        val senderIcon = itemView.circle_sender_video!!

        val cardContainer = itemView.video_container_left_card!!
        val senderTitle = itemView.messageText_sender_video_left!!

    }




    class TargetMapHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val message = itemView.messageText_map_left!!
        val mapView = itemView.mapview_left!!
        val dateHeader = itemView.header_map_left!!
        val time = itemView.time_map_left

        val messageLayout = itemView.message_layout_map_left!!
        val senderIcon = itemView.circle_sender_map!!

        val container = itemView.container_map_left!!
        val senderTitle = itemView.messageText_map_sender_left!!

    }

    class MyMapHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val message = itemView.messageText_map_right!!
        val mapView = itemView.mapview_right!!
        val dateHeader = itemView.header_map_right!!
        val messageStatus = itemView.delivery_status_map_right!!
        val messageLayout = itemView.message_layout_map_right!!
        val time = itemView.time_map_right!!


        val container = itemView.container_map_right!!


    }


    class TextHeaderHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val text = itemView.header_textView!!
        val dateTextView = itemView.header_date_text!!
    }

}