package fragment.soul.com.fragmentexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sould on 2016-03-16.
 */
public class MenuFragment extends Fragment implements OnClickListener{

	public static final int ITEM_TYPE_ADD 	 = 1;
	public static final int ITEM_TYPE_DEL 	 = 2;
	public static final int ITEM_TYPE_SELECT = 3;

	OnMenuClickListener mOnMenuClickListener = null;

	Button btn_add 		= null;
	Button btn_del 		= null;
	Button btn_select 	= null;

	ChildFragment mViewerFramgent = null;
	ChildFragment mViewerFragment1 = null;
	ChildFragment mViewerFragment2 = null;
	ChildFragment mViewerFragment3 = null;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mViewerFramgent = new ChildFragment();
		mViewerFragment1 = new ChildFragment();
		mViewerFragment2 = new ChildFragment();
		mViewerFragment3 = new ChildFragment();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_menu, container, false);
		btn_add = (Button)v.findViewById(R.id.btn_add);
		btn_del = (Button)v.findViewById(R.id.btn_del);
		btn_select = (Button)v.findViewById(R.id.btn_select);

		btn_add.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_select.setOnClickListener(this);

		return v;
	}

	public void setOnClickListener(OnMenuClickListener ln)
	{
		mOnMenuClickListener = ln;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.btn_add :
			{
				Log.d(UtilsLogKey.getTAG(getContext()), "Btn_add");
				Bundle bundle = new Bundle();
				bundle.putInt("layoutX", 0);
				bundle.putInt("layoutY", 0);
				mViewerFramgent.setArguments(bundle);

				Bundle bundle1 = new Bundle();
				bundle1.putInt("layoutX", 960);
				bundle1.putInt("layoutY", 0);
				mViewerFragment1.setArguments(bundle1);

				Bundle bundle2 = new Bundle();
				bundle2.putInt("layoutX", 0);
				bundle2.putInt("layoutY", 500);
				mViewerFragment2.setArguments(bundle2);

				Bundle bundle3 = new Bundle();
				bundle3.putInt("layoutX", 960);
				bundle3.putInt("layoutY", 500);
				mViewerFragment3.setArguments(bundle3);

				getFragmentManager()
						.beginTransaction()
						.add(R.id.viewer_fragment_container, mViewerFramgent)
						.add(R.id.viewer_fragment_container, mViewerFragment1)
						.add(R.id.viewer_fragment_container, mViewerFragment2)
						.add(R.id.viewer_fragment_container, mViewerFragment3)
						.commit();
				break;
			}
			case R.id.btn_select :
			{
				Log.d(UtilsLogKey.getTAG(getContext()), "Btn_select");
				if(mViewerFramgent.isVisible() == true &&
						mViewerFragment1.isVisible() == true &&
						mViewerFragment2.isVisible() == true &&
						mViewerFragment3.isVisible()==true){
					getFragmentManager()
							.beginTransaction()
							.show(mViewerFramgent)
							.show(mViewerFragment1)
							.show(mViewerFragment2)
							.show(mViewerFragment3)
							.commit();
				}
				break;
			}
			case R.id.btn_del :
			{
				Log.d(UtilsLogKey.getTAG(getContext()), "Btn_del");
				if(mViewerFramgent.isVisible() == true &&
						mViewerFragment1.isVisible() == true &&
						mViewerFragment2.isVisible() == true &&
						mViewerFragment3.isVisible()==true){
					getFragmentManager()
							.beginTransaction()
							.hide(mViewerFramgent)
							.hide(mViewerFragment1)
							.hide(mViewerFragment2)
							.hide(mViewerFragment3)
							.commit();
				}
				break;
			}
		}
	}

	public interface OnMenuClickListener
	{
		void onClick();
	}
}
