package com.example.expandablerecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expandablerecyclerview.R
import com.example.expandablerecyclerview.adapter.LanguageAdapter
import com.example.expandablerecyclerview.databinding.ActivityMainBinding
import com.example.expandablerecyclerview.model.LanguageData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var languageList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = LanguageAdapter(languageList)
        binding.recyclerView.adapter = adapter

    }

    private fun addDataToList() {
        languageList.add(
            LanguageData(
                "Kotlin",
                R.drawable.kotlin,
                "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. " +
                        "Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, " +
                        "but type inference allows its syntax to be more concise."
            )
        )
        languageList.add(
            LanguageData(
                "Swift",
                R.drawable.swift,
                "Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community."
            )
        )
        languageList.add(
            LanguageData(
                "Java",
                R.drawable.java,
                "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible."
            )
        )
        languageList.add(
            LanguageData(
                "Java Script",
                R.drawable.javascript,
                "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web," +
                        " alongside HTML and CSS. As of 2022, 98% of websites use JavaScript on the client side for webpage behavior," +
                        " often incorporating third-party libraries.",
            )
        )
        languageList.add(
            LanguageData(
                "C++",
                R.drawable.cplusplus,
                "C++ is a high-level general-purpose programming language created by Danish computer scientist Bjarne Stroustrup as an extension of the C programming language, or C with Classes."
            )
        )
        languageList.add(
            LanguageData(
                "C#",
                R.drawable.csharp,
                "C# is a general-purpose, high-level multi-paradigm programming language. " +
                        "C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic," +
                        " object-oriented, and component-oriented programming disciplines."
            )
        )
        languageList.add(
            LanguageData(
                "HTML",
                R.drawable.html,
                "The HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser."
            )
        )
        languageList.add(
            LanguageData(
                "Python",
                R.drawable.python,
                "Python is a high-level, general-purpose programming language." +
                        " Its design philosophy emphasizes code readability with the use of significant indentation."
            )
        )
    }
}