package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView screen;
    Button btn1,btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnSub, btnMul,btnDiv,btnEqual, btnPoint,btnAC,btnBack,btnPower,btnAns;
    String input, answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.display);
        btn0 = findViewById(R.id.zero);
        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);
        btnAdd = findViewById(R.id.add);
        btnSub= findViewById(R.id.sub);
        btnMul = findViewById(R.id.mul);
        btnDiv = findViewById(R.id.div);
        btnEqual = findViewById(R.id.equals);
        btnPoint = findViewById(R.id.point);
        btnPower = findViewById(R.id.power);
        btnAC= findViewById(R.id.ac);
        btnBack = findViewById(R.id.back);
        btnAns = findViewById(R.id.ans);

    }

    public void buttonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC":
                input="";
                break;
            case "Ans":
                input+=answer;
                break;
            case "*":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case "=":
                Solve();
                answer=input;
            case "<-":
                String newText = input.substring(0,input.length()-1);
                input = newText;
                break;
            default:
                if(input==null)
                    input="";
                if(data.equals("+") || data.equals("/") || data.equals("-")){
                    Solve();
                    input+=data;
                }
                else
                    input+=data;

        }
        screen.setText(input);
    }
    public void Solve(){
        if(input.split("\\*").length==2){
            String[] nums = input.split("\\*");
            try{
                double mul = Double.parseDouble(nums[0])*Double.parseDouble(nums[1]);
                input = mul+"";
            }catch (Exception e){

            }
        }
        else if(input.split("/").length==2){
            String[] nums = input.split("/");
            try{
                double div = Double.parseDouble(nums[0])/Double.parseDouble(nums[1]);
                input = div+"";
            }catch (Exception e){

            }
        }
        else if(input.split("\\^").length==2){
            String[] nums = input.split("\\^");
            try{
                double pow = Math.pow(Double.parseDouble(nums[0]),Double.parseDouble(nums[1]));
                input = pow+"";
            }catch (Exception e){

            }
        }
        else if(input.split("\\+").length==2){
            String[] nums = input.split("\\+");
            try{
                double add = Double.parseDouble(nums[0]) + Double.parseDouble(nums[1]);
                input = add+"";
            }catch (Exception e){

            }
        }
        else if(input.split("-").length>1){
            String[] nums = input.split("-");
            if(nums[0]=="" && nums.length==2){
                nums[0]=0+"";
            }
            try{
                double sub = Double.parseDouble(nums[0])-Double.parseDouble(nums[1]);
                input = sub+"";
            }catch (Exception e){

            }
        }
        // to remove last digit .0 from result number
        /*
        String n[] = input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input = n[0];
            }
        }
        */
        screen.setText(input);
    }

}