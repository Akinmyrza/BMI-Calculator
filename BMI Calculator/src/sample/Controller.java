package sample;

import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    private static final DecimalFormat df = new DecimalFormat("#.0");

    @FXML
    private TextField TFW;
    @FXML
    private TextField TFH;
    @FXML
    private TextField TFBMI;
    @FXML
    private TextField TFBMI2;
    @FXML
    private ImageView IMG;
    @FXML

    private void calculateButtonPressed(ActionEvent event) {
        try {
            double weight = Double.parseDouble(TFW.getText());
            double height = Double.parseDouble(TFH.getText());
            double bmi = weight/((height/100)*(height/100));
            TFBMI.setText(String.valueOf(df.format(bmi)));
            Image image1 = new Image("https://www.designnominees.com/application/upload/Apps/2017/01/bmi-calculator-weight-loss-169.png");
            IMG.setImage(image1);
            if (bmi < 18.5){
                TFBMI2.setText("Underweight");
                Image image2 = new Image("https://healthierujunction.files.wordpress.com/2011/05/skinnystickfigure.jpg");
                IMG.setImage(image2);
            }else if (18.5 <= bmi && bmi < 25){
                TFBMI2.setText("Normal weight");
                Image image3 = new Image("https://blogs.psychcentral.com/adhd-millennial/files/2017/05/normal_person.jpeg");
                IMG.setImage(image3);
            }else if (25 <= bmi && bmi < 30){
                TFBMI2.setText("Overweight");
                Image image4 = new Image("https://friendlystock.com/wp-content/uploads/2018/11/4-overweight-black-man-in-front-of-mirror-cartoon-clipart.jpg");
                IMG.setImage(image4);
            }else if(30<= bmi){
                TFBMI2.setText("Obesity");
                Image image5 = new Image("https://images-prod.healthline.com/hlcmsresource/images/topic_centers/sponsored-programs/obesity/12454-To_Others_with_Obesity_OK_to_Ask_for_Help-732x549-Thumbnail.jpg");
                IMG.setImage(image5);
            }else{
                TFBMI2.setText("Invalid input");
                IMG.setImage(image1);
            }

        }
        catch (NumberFormatException ex) {
            TFW.setText("in kilograms");
            TFW.selectAll();
            TFW.requestFocus();
            TFW.setText("in centimetres");
            TFH.selectAll();
            TFH.requestFocus();
            Image image1 = new Image("https://www.designnominees.com/application/upload/Apps/2017/01/bmi-calculator-weight-loss-169.png");
            IMG.setImage(image1);
        }
    }

    public void initialize() {
        Image image1 = new Image("https://www.designnominees.com/application/upload/Apps/2017/01/bmi-calculator-weight-loss-169.png");
        IMG.setImage(image1);
    }
}