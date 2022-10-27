package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.EditText
import android.widget.ImageButton
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    lateinit var urlEditText: EditText
    lateinit var goButton: ImageButton
    lateinit var webView: WebView
    lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.ImageButton)
        webView = findViewById(R.id.webView)


        requestQueue = Volley.newRequestQueue(this)

        webView.settings.javaScriptEnabled = true

        goButton.setOnClickListener {
            val userInput = urlEditText.text
            requestQueue.add(
                StringRequest(Request.Method.GET, "$userInput", {
                    webView.loadDataWithBaseURL("", it, "text/html", "utf-8", null)
                }, {})
            )
        }
    }
}