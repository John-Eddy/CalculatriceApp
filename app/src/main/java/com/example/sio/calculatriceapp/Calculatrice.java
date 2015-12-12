package com.example.sio.calculatriceapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import android.view.View.OnClickListener;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculatrice extends AppCompatActivity {

    public float memoire = 0;
    public char derniereOpe ;
    int nbCalcul = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Déclaration des items
        final TextView affichage = (TextView) findViewById(R.id.textViewAffichage);

        Button bouton0 = (Button) findViewById(R.id.button0);
        Button bouton1 = (Button) findViewById(R.id.button1);
        Button bouton2 = (Button) findViewById(R.id.button2);
        Button bouton3 = (Button) findViewById(R.id.button3);
        Button bouton4 = (Button) findViewById(R.id.button4);
        Button bouton5 = (Button) findViewById(R.id.button5);
        Button bouton6 = (Button) findViewById(R.id.button6);
        Button bouton7 = (Button) findViewById(R.id.button7);
        Button bouton8 = (Button) findViewById(R.id.button8);
        Button bouton9 = (Button) findViewById(R.id.button9);
        Button boutonPoint = (Button) findViewById(R.id.buttonPoint);
        final Button boutonEgale = (Button) findViewById(R.id.buttonEgale);
        Button boutonAddition = (Button) findViewById(R.id.buttonAddition);
        final Button boutonSoustraction = (Button) findViewById(R.id.buttonSoustraction);
        Button boutonMultiplaction = (Button) findViewById(R.id.buttonMultiplication);
        Button boutonDivision = (Button) findViewById(R.id.buttonDivision);
        Button boutonC = (Button) findViewById(R.id.buttonC);
        Button boutonCE = (Button) findViewById(R.id.buttonCE);

        bouton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "0");
            }
        });
        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "1");
            }
        });
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "2");
            }
        });
        bouton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "3");
            }
        });
        bouton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "4");
            }
        });
        bouton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "5");
            }
        });
        bouton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "6");
            }
        });
        bouton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "7");
            }
        });
        bouton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "8");
            }
        });
        bouton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText(affichage.getText() + "9");
            }
        });
        boutonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String)affichage.getText();
                //si l'affichage ne contien pas déjà de points
                if( text.indexOf(".") == -1 ){
                    if(text == ""){
                        text="0.";
                    }
                    else {
                        text += ".";
                    }

                }
                affichage.setText(text);
            }
        });
        boutonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText("");
            }
        });

        boutonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichage.setText("");
                memoire=0;
            }
        });

        boutonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (affichage.getText() != "" && affichage.getText() != null) {
                    //memoire reçois memoir plus la valeur converti en float de l'affichage
                    memoire += Float.parseFloat((String) affichage.getText());

                    affichage.setText("");
                    derniereOpe = '+';
                }
            }
        });

        boutonSoustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (affichage.getText() != "" && affichage.getText() != null) {
                    memoire -= Float.parseFloat((String) affichage.getText());

                    affichage.setText("");
                    derniereOpe = '-';
                }
            }
        });
        boutonEgale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (affichage.getText() != "" && affichage.getText() != null) {
                    if(derniereOpe == '+')
                    {
                        memoire += Float.parseFloat((String) affichage.getText());
                    }
                    else if(derniereOpe == '-')
                    {
                        memoire -= Float.parseFloat((String) affichage.getText());
                    }
                   affichage.setText((String) Float.toString(memoire));
                }
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculatrice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

