package fragment.soul.com.fragmentexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by sould on 2016-03-15.
 */
public class ChildFragment extends Fragment {

	private static final String TAG  = "ChildFragment";
	private static final int 	REQUEST_CODE_URI = 1;

	private ImageView imageItem;
	private FrameLayout layout = null;

	int layoutX = 0;
	int layoutY = 0;

	public static ChildFragment newInstance(){
		ChildFragment f = new ChildFragment();
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Bundle argBundle = getArguments();
		if(argBundle != null){
			Log.d("log", argBundle.toString());
			layoutY = argBundle.getInt("layoutY");
			layoutX = argBundle.getInt("layoutX");
			Log.e("log", "layoutX : "+ layoutX);
			Log.w("log", "layoutY : "+ layoutY);
		}
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.viewer_layout, container, false);
		layout = (FrameLayout)view.findViewById(R.id.viewer_fragment_container);
		imageItem = (ImageView)view.findViewById(R.id.show_image);
//		imageItem = new ImageView(getActivity());
		imageItem.setLayoutParams(new ViewGroup.LayoutParams(960, 540));
		imageItem.setX(layoutX);
		imageItem.setY(layoutY);
		imageItem.setScaleType(ImageView.ScaleType.FIT_XY);

		Glide.with(getActivity())
				.load(randomImage())
				.into(imageItem);
		layout.addView(imageItem);
		return view;
	}

	private Integer randomImage(){
		int drawbleArr[] = {
				R.drawable.img1, R.drawable.img2,
				R.drawable.img3, R.drawable.img4,
				R.drawable.img5, R.drawable.img6,
				R.drawable.img7};

		int random = (int)(Math.random()*6);
		return drawbleArr[random];
	}
}
