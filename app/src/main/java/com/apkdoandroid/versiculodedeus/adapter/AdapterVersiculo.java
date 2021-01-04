package com.apkdoandroid.versiculodedeus.adapter;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.versiculodedeus.R;
import com.apkdoandroid.versiculodedeus.helper.VersiculoDao;
import com.apkdoandroid.versiculodedeus.model.MenuModel;
import com.apkdoandroid.versiculodedeus.model.Versiculo;

import java.util.List;

public class AdapterVersiculo extends RecyclerView.Adapter<AdapterVersiculo.MyViewModel> {
    private List<Versiculo> versiculos;
    private  Context context;
    private Versiculo versiculo= new Versiculo();
    public AdapterVersiculo(List<Versiculo> versiculos) {
        this.versiculos = versiculos;
    }

    public AdapterVersiculo(List<Versiculo> versiculos, Context context) {
        this.versiculos = versiculos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View lista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_versiculo,parent,false);
        return new MyViewModel(lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewModel holder, int position) {
         versiculo = versiculos.get(position);
        holder.texto.setText(versiculo.getTexto());
        holder.autor.setText(versiculo.getAutor());
        holder.textid.setText(versiculo.getId()+"");
        if(versiculo.getFavorito() == 0){ // sem estrela
            holder.amei.setImageResource(R.drawable.ic__favorite__24);

        }else{
            holder.amei.setImageResource(R.drawable.ic_favorite_on_24);
        }
    }

    @Override
    public int getItemCount() {
        return versiculos.size();
    }
    public void compartilhar(String autor, String texto){

        Intent intent = new Intent(Intent.ACTION_SEND);


        intent.putExtra(Intent.EXTRA_SUBJECT,autor);
        intent.putExtra(Intent.EXTRA_TEXT,texto+"\n\n -"+autor);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, "Compartilhar: "+autor));

    }
    public String copiar(String texto, String autor){
        //ClipData copia = ClipData.newPlainText(texto, autor);
        //para cópia:
        ClipboardManager clipboar = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copiar",texto+"\n\n -"+autor);
        clipboar.setPrimaryClip(clip);

        //E cole:
        String dados = "";
        // Se contiver dados, decida se você pode manipular os dados.
        if(!(clipboar.hasPrimaryClip())){

        }else if(!(clipboar.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))){
            // visto que a área de transferência contém dados, mas não é um texto simples
        }else{

            // já que a área de transferência contém texto simples.
            ClipData.Item item=  clipboar.getPrimaryClip().getItemAt(0);


            // Obtém a área de transferência como texto.
            dados = item.getText().toString();
            Toast.makeText(context, "Copiado", Toast.LENGTH_SHORT).show();

        }
        return dados;
    }
    public void amei (TextView textid, ImageView amei){
        Long id = Long.parseLong( textid.getText().toString());
        versiculo.setId(id);
//        versiculo.setAutor(autor.getText().toString());
//        versiculo.setTexto(texto.getText().toString());
        VersiculoDao dao = new VersiculoDao(context);

        if(versiculo.getFavorito() == 0){

            versiculo.setFavorito(1);
            if(dao.atualizar(versiculo)){

                amei.setImageResource(R.drawable.ic_favorite_on_24);
            }

        }else{
            versiculo.setFavorito(0);
            if(dao.atualizar(versiculo)){
                amei.setImageResource(R.drawable.ic__favorite__24);
            }
        }
    }

    class MyViewModel extends RecyclerView.ViewHolder{
        private TextView autor;
        private TextView texto;
        private TextView textid;
        private TextView textamei;
        private TextView textcopiar;
        private TextView textcompartilhar;
        private ImageView amei;

        public MyViewModel(@NonNull View itemView) {
            super(itemView);
            autor = itemView.findViewById(R.id.textViewAutor);
            texto = itemView.findViewById(R.id.textViewTextoVersiculo);
            textid = itemView.findViewById(R.id.textViewid);
            textamei = itemView.findViewById(R.id.textViewAmei);
            textcopiar = itemView.findViewById(R.id.textViewCopiar);
            textcompartilhar = itemView.findViewById(R.id.textViewCompartilhar);
            amei = itemView.findViewById(R.id.imageViewAmei);
            amei.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    amei(textid,amei);
                }
            });
            textamei.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    amei(textid,amei);

                }
            });
            textcopiar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = texto.getText().toString();
                    String aut =autor.getText().toString();
                    copiar(text,aut);
                }
            });
            textcompartilhar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = texto.getText().toString();
                    String aut =autor.getText().toString();
                    compartilhar(aut,text);
                }
            });
        }
    }
}
