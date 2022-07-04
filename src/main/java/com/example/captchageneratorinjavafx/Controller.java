package com.example.captchageneratorinjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label captchaLabel;

    @FXML
    private TextField captchaCode;

    @FXML
    private Button refreshCaptcha;

    @FXML
    private Button submit;
    @FXML
    private Label msg;

    public String Captcha;
    public String GenerateCaptcha() {

        char[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's','t', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
                'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int max = 36;
        String captcha="";
        int min = 0;
        for(int i =0;i<6;i++) {
            int rand = (int)Math.floor(Math.random()*(max-min+1)+min);
            captcha+=data[rand];
        }
        System.out.println(captcha);
        return captcha;

    }

    @FXML
    void onRefreshCaptcha(ActionEvent e) {
        Captcha = GenerateCaptcha();
        captchaLabel.setText(Captcha);
        System.out.println(Captcha);
        captchaCode.setText("");
    }

    @FXML
    void onSubmit(ActionEvent event) {
        if(captchaCode.getText().equals(String.valueOf(Captcha))){
            msg.setText("You have entered correct code!");
            msg.setTextFill(Color.GREEN);
        }else{
            msg.setText("You have entered wrong");
            msg.setTextFill(Color.RED);
            Captcha = GenerateCaptcha();
            captchaLabel.setText(Captcha);
            captchaCode.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imageView = new ImageView(getClass().getResource("refresh.png").toExternalForm());
        refreshCaptcha.setGraphic(imageView);
        String Captcha = GenerateCaptcha();
        captchaLabel.setText(Captcha);
    }
}