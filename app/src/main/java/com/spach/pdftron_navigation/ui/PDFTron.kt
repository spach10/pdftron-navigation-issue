package com.spach.pdftron_navigation.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pdftron.pdf.config.ViewerBuilder2
import com.pdftron.pdf.config.ViewerConfig
import com.spach.pdftron_navigation.R
import com.spach.pdftron_navigation.databinding.FragmentPdftronBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PDFTron.newInstance] factory method to
 * create an instance of this fragment.
 */
class PDFTron : Fragment() {

    private var _binding: FragmentPdftronBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPdftronBinding.inflate(inflater, container, false)

        initPdfTron()

        return binding.root
    }

    private fun initPdfTron() {
        val config = ViewerConfig.Builder()
                .toolbarTitle("Dummy.pdf")
            .fullscreenModeEnabled(false)
            .showSearchView(true)
            .showBookmarksView(false)
            .showOutlineList(false)
            .multiTabEnabled(false)
            .build()
        val fragment = ViewerBuilder2.withUri(Uri.parse("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"))
            .usingConfig(config)
            .build(requireContext())

        childFragmentManager.beginTransaction()
            .replace(binding.root.id, fragment)
            .commit()
    }
}