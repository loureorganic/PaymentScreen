package com.example.myapplication.view.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.model.Pagamento;
import com.example.myapplication.model.PaymentModel;
import com.example.myapplication.presenter.PaymentPresenter;
import com.example.myapplication.view.PagamentoAdapter;
import com.example.myapplication.view.PaymentView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PaymentView {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private PaymentPresenter presenter;
    private PagamentoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaymentModel model = new PaymentModel();

        setSupportActionBar(binding.toolbar);

        presenter = new PaymentPresenter(model, this);

        binding.addPaymentWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddPaymentWayClicked();
            }
        });

        binding.buttonInsertPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueText = binding.editTextValue.getText().toString();
                String paymentWay = binding.menuSpinnerPaymentWay.getSelectedItem().toString();
                presenter.onInsertPaymentClicked(valueText, paymentWay);
            }
        });

        presenter.initialize();
    }

    @Override
    public void showInputFields() {
        binding.inputLayoutValue.setVisibility(View.VISIBLE);
        binding.menuSpinnerPaymentWay.setVisibility(View.VISIBLE);
        binding.buttonInsertPayment.setVisibility(View.VISIBLE);
        binding.addPaymentWay.setVisibility(View.GONE);
    }

    @Override
    public void hideInputFields() {
        binding.inputLayoutValue.setVisibility(View.GONE);
        binding.menuSpinnerPaymentWay.setVisibility(View.GONE);
        binding.buttonInsertPayment.setVisibility(View.GONE);
        binding.addPaymentWay.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPayValue(double value) {
            binding.payPaymentValue.setText("R$" + value);
    }

    @Override
    public void setRestValue(double value) {
        binding.valueRestPaymentValue.setText("R$" + value);
        binding.alertPaymentValue.setText("R$" + value);
    }

    @Override
    public void setReduceValue(double value) {
        binding.parcelInformation.setText("Reduzido para R$" + value);
    }

    @Override
    public void setParcelsValue(double value) {
        binding.valueParcel.setText("R$" + value);
        binding.valueParcel1.setText("R$" + value);
    }

    @Override
    public void setDebitValue(double value) { binding.totalPaymentValue.setText("R$" + value);}


    @Override
    public void showPaymentsList(List<Pagamento> pagamentos) {
        adapter = new PagamentoAdapter(pagamentos);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}