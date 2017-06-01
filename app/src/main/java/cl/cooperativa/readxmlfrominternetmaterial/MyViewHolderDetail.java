package cl.cooperativa.readxmlfrominternetmaterial;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by innova6 on 24-05-2017.
 */

public class MyViewHolderDetail extends RecyclerView.ViewHolder {
    TextView titleArticulo, detalleArticulo;
    ImageView imageArticulo;

    public MyViewHolderDetail(View itemView) {
        super(itemView);
        titleArticulo=(TextView) itemView.findViewById(R.id.titleImage);
        detalleArticulo=(TextView) itemView.findViewById(R.id.textContentImageDetail);
        imageArticulo=(ImageView) itemView.findViewById(R.id.imageHeader);

    }
}
