package otus.gpb.homework.fragments.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.activity.addCallback
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.go_to_fragment_AA).setOnClickListener {

            val color = ColorGenerator.generateColor()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentAA.newInstance(color))
                .addToBackStack(null)
                .commit()
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            val count = parentFragmentManager.backStackEntryCount

            if (count > 1)
                parentFragmentManager.popBackStack()
            else
                requireActivity().finish()
        }
    }
}
