
	

package com.ayush.pdfviewer;
import com.ayush.pdfviewer.pdf_read;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayush.pdfviewer.R;

public class MainActivity extends Activity {


	private View _bg__android_large___1_ek2;
	private View ellipse_1;
	private View ellipse_2;
	private View rectangle_1;
	private View rectangle_2;
	private View rectangle_1_ek1;
	private View rectangle_2_ek1;
	private TextView pdf_reader___converter;
	private ImageView kisspng_computer_icons_pdf_computer_file_document_applicat_5c9c7cca5ad172_1;
	private ImageView photography_icon_png_2401_1;
	private ImageView pngaaa_1;
	private ImageView pngwing_1;
	private TextView read_pdf;
	private TextView read_doc;
	private TextView instant_pdf;
	private TextView image_to_pdf;
	private ImageView pngwing_2;
	private ImageView information_gd865d44a2_1280_1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.android_large___1);

		
		_bg__android_large___1_ek2 = (View) findViewById(R.id._bg__android_large___1_ek2);
		ellipse_1 = (View) findViewById(R.id.ellipse_1);
		ellipse_2 = (View) findViewById(R.id.ellipse_2);
		rectangle_1 = (View) findViewById(R.id.rectangle_1);
		rectangle_2 = (View) findViewById(R.id.rectangle_2);
		rectangle_1_ek1 = (View) findViewById(R.id.rectangle_1_ek1);
		rectangle_2_ek1 = (View) findViewById(R.id.rectangle_2_ek1);
		pdf_reader___converter = (TextView) findViewById(R.id.pdf_reader___converter);
		kisspng_computer_icons_pdf_computer_file_document_applicat_5c9c7cca5ad172_1 = (ImageView) findViewById(R.id.kisspng_computer_icons_pdf_computer_file_document_applicat_5c9c7cca5ad172_1);
		photography_icon_png_2401_1 = (ImageView) findViewById(R.id.photography_icon_png_2401_1);
		pngaaa_1 = (ImageView) findViewById(R.id.pngaaa_1);
		pngwing_1 = (ImageView) findViewById(R.id.pngwing_1);
		read_pdf = (TextView) findViewById(R.id.read_pdf);
		read_doc = (TextView) findViewById(R.id.read_doc);
		instant_pdf = (TextView) findViewById(R.id.instant_pdf);
		image_to_pdf = (TextView) findViewById(R.id.image_to_pdf);
		pngwing_2 = (ImageView) findViewById(R.id.pngwing_2);
		information_gd865d44a2_1280_1 = (ImageView) findViewById(R.id.information_gd865d44a2_1280_1);


		rectangle_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Create an Intent to start the PdfReadActivity
				Intent intent = new Intent(view.getContext(), Read_pdf.class);

				startActivity(intent);
			}
		});

	
	}
}
	
	