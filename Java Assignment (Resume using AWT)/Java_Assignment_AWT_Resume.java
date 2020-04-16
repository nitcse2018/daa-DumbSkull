
import java.awt.*;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.*;
class Assignment
{

	public static void main(String[] args) throws IOException
	{
        Frame f = new Frame ("Resume Writer");

        Label emailSpace = new Label("                     ");
        Label buttonSpace = new Label("                                          ");
        Label educationSpace = new Label("                     ");
        Label firstName = new Label("First Name: ", Label.LEFT);
        Label lastName = new Label("Last Name: ", Label.RIGHT);
        Label email = new Label("\nEmail: ", Label.LEFT);
        Label address = new Label("\nAddress: ", Label.LEFT);
        Label phoneNo = new Label("Phone Number: ", Label.LEFT);
        Label education = new Label("Educational Background: ");
        Label qualification = new Label("Qualifications: ");
        Label skills = new Label("Skills:- ");
        Label hitSubmit = new Label("Click on 'Submit' if you're done: ");
        
        TextField firstNameText = new TextField(15);
        TextField lastNameText = new TextField(15);
        TextField emailText = new TextField(30);
        TextField phoneText = new TextField(15);

        TextArea addressText=new TextArea();  
        addressText.setBounds(10,30, 200,200); 
        TextArea educationText=new TextArea();  
        educationText.setBounds(10,30, 200,200); 
        TextArea qualificationText=new TextArea();  
        qualificationText.setBounds(10,30, 200,200); 

        Checkbox checkbox1 = new Checkbox("Java", true);  
        checkbox1.setBounds(100,100, 50,50); 
        Checkbox checkbox2 = new Checkbox("C++");  
        checkbox2.setBounds(100,150, 50,50);   
        Checkbox checkbox3 = new Checkbox("Python");  
        checkbox3.setBounds(100,200, 50,50);   

        Button submit = new Button ("Submit");

        f.add(firstName); f.add(firstNameText);
        f.add(lastName); f.add(lastNameText);
        f.add(email); f.add(emailText);
        f.add(emailSpace);
        f.add(address); f.add(addressText);
        f.add(phoneNo); f.add(phoneText);
        f.add(educationSpace);
        f.add(education); f.add(educationText);
        f.add(qualification); f.add(qualificationText);
        f.add(skills); f.add(checkbox1); f.add(checkbox2); f.add(checkbox3);
        f.add(buttonSpace);
        f.add(hitSubmit);
        f.add(submit);

        submit.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ae){
                
            String resumeText;
            resumeText = "\nResume Details:- ";
            resumeText = addString(resumeText, firstNameText.getText(), "First Name: ");
            resumeText = addString(resumeText, lastNameText.getText(), "Last Name: ");
            resumeText = addString(resumeText, emailText.getText(), "Email: ");
            resumeText = addString(resumeText, phoneText.getText(), "Phone Number: ");
            resumeText = addString(resumeText, addressText.getText(), "Address: ");
            resumeText = addString(resumeText, educationText.getText(), "Educational Background: ");
            resumeText = addString(resumeText, qualificationText.getText(), "Qualifications: ");
            resumeText = addString(resumeText, "", "Skills: ");
            if(checkbox1.getState() == true)
                resumeText = resumeText+"\nJava";
            if(checkbox2.getState() == true)
                resumeText = resumeText+"\nC++";
            if(checkbox3.getState() == true)
                resumeText = resumeText+"\nPython";
            
            System.out.println(resumeText);
            try{
            //the resume.txt is created in the same folder as this .java file is present in
                File file = new File("./resume.txt");
            FileOutputStream fos = new FileOutputStream(file);
            if(!file.exists())
                file.createNewFile();
            byte[] bytesArray = resumeText.getBytes();
            fos.write(bytesArray);
            fos.flush();
            System.out.println("File written successfully");
            fos.close();
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
            
        }});

        f.setLayout(new FlowLayout());

        f.setSize(480, 800);
        f.setVisible(true);
    }
    public static String addString(String resumeText, String temp, String adder){
        adder="\n"+adder;
        return (resumeText+adder+temp);
    }
    
}
