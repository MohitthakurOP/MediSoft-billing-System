package com.billing.MedcialBillingSystem;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCode extends JFrame{
	
	private static String total;

	public QRCode(String total){
		  this.total = total;

        String upiString = "upi://pay?pa=9579055416@axl&pn=Recipient&mc=1234&tid=123456&tr=Payment123&tn=Payment%20Description&am="+total+"&cu=INR";

        try {
        	String path = "QRCode.png";
            generateQRCode(upiString, path);
//            System.out.println("QR Code generated successfully!");
            displayQR(total);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
    }
	

    public static void main(String[] args) {
        new QRCode(total);
    }
    private static void generateQRCode(String text, String filePath) throws WriterException, IOException {
        int width = 300;
        int height = 300;

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.H);

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        MatrixToImageWriter.writeToFile(bitMatrix, "PNG", new File(filePath));
//        System.out.println("File path: " + new File(filePath).getAbsolutePath());
    }

	private void displayQR(String total) {
		this.total=total;
		ImageIcon i1 = new ImageIcon("QRCode.png");
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(40, 10, 250,250);
		add(image);
		
		JLabel j1= new JLabel("₹"+total);
		j1.setBounds(130, 230, 100, 100);
	    j1.setFont(new Font("System",Font.BOLD,28));
		add(j1);
		
		setLayout(null);
	    setSize(350, 350);
	    setLocation(570,200);
//      setUndecorated(true);
        setVisible(true);
	
	}
}
