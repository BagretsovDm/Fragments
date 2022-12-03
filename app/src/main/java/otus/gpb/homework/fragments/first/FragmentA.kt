package otus.gpb.homework.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.addCallback
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.go_to_fragment_AA).setOnClickListener {

            val color = ColorGenerator.generateColor()

            childFragmentManager.beginTransaction()
                .replace(R.id.child_fragment_container, FragmentAA.newInstance(color))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback {
            val count = childFragmentManager.backStackEntryCount

            if (count > 1)
                childFragmentManager.popBackStack()
            else
                requireActivity().finish()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}