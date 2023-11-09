import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    private JPanel panelMain;
    private JLabel iconLeft;
    private JLabel iconRight;
    private JTextField empName;
    private JTextField ratePerHr;
    private JTextField hrPerDay;
    private JTextField daysWorked;
    private JTextField taxTf;
    private JTextField philhealthTf;
    private JTextField sssTf;
    private JTextField grossSalaryTf;
    private JTextField deductionTf;
    private JTextField grossSal;
    private JTextField totalDed;
    private JTextField netSalaryTf;
    private JButton computeButton;

    public Main() {
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Initializing variables
                int totalHours, grossSalary, tax, philhealth, sss, totalDeduction, netSalary;
                float taxRate = 0.15f, philhealthRate = 0.05f, sssRate = 0.02f;

                //Gross salary
                totalHours = Integer.parseInt(hrPerDay.getText()) * Integer.parseInt(daysWorked.getText());
                grossSalary = totalHours * Integer.parseInt(ratePerHr.getText());

                //Calculating deductibles
                tax = (int) (taxRate * grossSalary);
                philhealth = (int) (philhealthRate * grossSalary);
                sss = (int) (sssRate * grossSalary);
                totalDeduction = tax + philhealth + sss;

                //Calculating net salary
                netSalary = grossSalary - totalDeduction;

                //Updating UI elements
                grossSal.setText(String.valueOf(grossSalary));
                grossSalaryTf.setText(String.valueOf(grossSalary));
                netSalaryTf.setText(String.valueOf(netSalary));
                totalDed.setText(String.valueOf(totalDeduction));
                deductionTf.setText(String.valueOf(totalDeduction));
                taxTf.setText(String.valueOf(tax));
                philhealthTf.setText(String.valueOf(philhealth));
                sssTf.setText(String.valueOf(sss));

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setContentPane(m.panelMain);
        m.setTitle("Simple payroll system");
        m.setSize(1000, 400);
        m.setBounds(184, 184, 1000, 400);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
