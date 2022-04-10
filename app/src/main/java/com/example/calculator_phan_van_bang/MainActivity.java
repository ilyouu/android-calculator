package com.example.calculator_phan_van_bang;


import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*; // em dùng library Mathparser để tính cho nhanh :v

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText manhinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manhinh = findViewById(R.id.txtManHinh);
        manhinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.manhinh).equals(manhinh.getText().toString())) {
                    manhinh.setText("");
                }
            }
        });

    }


    private void txtManHinh(String str) {
        String oldStr = manhinh.getText().toString();
        int cursorPos = manhinh.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (getString(R.string.manhinh).equals(manhinh.getText().toString())) {
            manhinh.setText(str);
            manhinh.setSelection(cursorPos + 1);
        } else {
            manhinh.setText(String.format("%s%s%s", leftStr, str, rightStr));
            manhinh.setSelection(cursorPos + 1);
        }


    }


    public void btn0(View view) {
        txtManHinh("0");
    }

    public void btn1(View view) {
        txtManHinh("1");
    }

    public void btn2(View view) {
        txtManHinh("2");
    }

    public void btn3(View view) {
        txtManHinh("3");
    }

    public void btn4(View view) {
        txtManHinh("4");
    }

    public void btn5(View view) {
        txtManHinh("5");
    }

    public void btn6(View view) {
        txtManHinh("6");
    }

    public void btn7(View view) {
        txtManHinh("7");
    }

    public void btn8(View view) {
        txtManHinh("8");
    }

    public void btn9(View view) {
        txtManHinh("9");
    }


    public void btnAC(View view) {
        manhinh.setText("");
    }

    public void btnC(View view) {
        int cursorPos = manhinh.getSelectionStart();
        int textLen = manhinh.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) manhinh.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            manhinh.setText(selection);
            manhinh.setSelection(cursorPos - 1);
        }
    }

    public void btnNoHope(View view) {

    }

    public void btnPhanTram(View view) {
        txtManHinh("%");
    }

    public void btnChia(View view) {
        txtManHinh("÷");
    }

    public void btnNhan(View view) {
        txtManHinh("×");
    }

    public void btnTru(View view) {
        txtManHinh("-");
    }

    public void btnCong(View view) {
        txtManHinh("+");
    }

    public void btnPhay(View view) {
        txtManHinh(".");
    }

    public void btnBang(View view) {
        String userExp = manhinh.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        // em dùng library Mathparser để tính cho nhanh :v
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        manhinh.setText(result);
        manhinh.setSelection(result.length());

    }

}