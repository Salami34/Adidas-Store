import javax.swing.JOptionPane;

public class AdidasStore {
    public static void main(String[] args) {
        boolean wantsToShopAgain;
        
        do{ 
        String customerName = JOptionPane.showInputDialog("Welcome to our Adidas store! Please enter your name:");
        String message = "Hello, " + customerName + "!\n";
        boolean wantsToBuyShoes = true;
        double totalCost = 0.0;

        StringBuilder purchasedItems = new StringBuilder(); // To store the list of purchased items

        while (wantsToBuyShoes) {
            String[] shoeModels = {
                    "Adidas Yeezy",
                    "Adidas Samba",
                    "Adidas Stan Smith",
                    "Adidas Adifom Superstar",
                    "Adidas Blue Gazelle",
                    "Adidas Handball Spezial",
                    "Adidas NMD_R1",
                    "Adidas Alphabounce+",
                    "Adidas Ozweego TR",
                    "Adidas Kaptir",
                    "Adidas Terrex Agravic TR Trail Running Shoes",
                    "Adidas Superstar"
            };

            String shoeChoice = (String) JOptionPane.showInputDialog(
                    null,
                    "Available Adidas shoes:",
                    "Adidas Store",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    shoeModels,
                    shoeModels[0]
            );

            if (shoeChoice != null) {
                double originalPrice = 0.0;

                if (shoeChoice.contains("Adidas Yeezy")) {
                    originalPrice = 22000.0;
                } else if (shoeChoice.contains("Adidas Samba")) {
                    originalPrice = 4000.0;
                } else if (shoeChoice.contains("Adidas Stan Smith")) {
                    originalPrice = 4500.0;
                } else if (shoeChoice.contains("Adidas Adifom Superstar")) {
                    originalPrice = 3600.0;
                } else if (shoeChoice.contains("Adidas Blue Gazelle")) {
                    originalPrice = 5000.0;
                } else if (shoeChoice.contains("Adidas Handball Spezial")) {
                    originalPrice = 5300.0;
                } else if (shoeChoice.contains("Adidas NMD_R1")) {
                    originalPrice = 8000.0;
                } else if (shoeChoice.contains("Adidas Alphabounce+")) {
                    originalPrice = 3710.0;
                } else if (shoeChoice.contains("Adidas Ozweego TR")) {
                    originalPrice = 4000.0;
                } else if (shoeChoice.contains("Adidas Kaptir")) {
                    originalPrice = 4360.0;
                } else if (shoeChoice.contains("Adidas Terrex Agravic TR Trail Running Shoes")) {
                    originalPrice = 4850.0;
                } else if (shoeChoice.contains("Adidas Superstar")) {
                    originalPrice = 5300.0;
                }

                String sizeInput = JOptionPane.showInputDialog("Enter your shoe size (US size):");
                double shoeSize = Double.parseDouble(sizeInput);

                String quantityInput = JOptionPane.showInputDialog("How many pairs would you like to purchase?");
                int quantity = Integer.parseInt(quantityInput);

                double subtotal = originalPrice * quantity;
                totalCost += subtotal;

                if (shoeChoice != null) {
                    // Update the purchasedItems StringBuilder with the new purchase
                    purchasedItems.append(quantity).append(" pairs of ").append(shoeChoice)
                            .append(" (Size ").append(shoeSize).append(" US) - ₱").append(subtotal).append("\n");
                }

                String anotherShoe = JOptionPane.showInputDialog("Do you want to purchase another pair of shoes? (yes/no)");
                wantsToBuyShoes = anotherShoe.equalsIgnoreCase("yes");
            } else {
                wantsToBuyShoes = false;
            }
        }

        // Display the list of purchased items
        JOptionPane.showMessageDialog(null, "You have purchased:\n" + purchasedItems.toString());

        // Display the total cost and ask for cash payment
        double discountedTotal = totalCost;
        if (totalCost >= 5 * 3200.0) {
            double discount = totalCost * 0.05;
            discountedTotal = totalCost - discount;
            JOptionPane.showMessageDialog(null, "Your total cost before discount: ₱" + totalCost + "\nYou are eligible for a 5% discount. Your new total cost is: ₱" + discountedTotal);
        } else {
            JOptionPane.showMessageDialog(null, "Your total cost: ₱" + totalCost);
        }

        // Ask for cash payment
        String cashInput = JOptionPane.showInputDialog("Please enter the cash amount for payment in PHP:");
        double cashAmount = Double.parseDouble(cashInput);

        // Process the payment and calculate change
        if (cashAmount >= discountedTotal) {
            double change = cashAmount - discountedTotal;
            JOptionPane.showMessageDialog(null, "Payment successful! Thank you for your purchase.\nChange: ₱" + change);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient cash. Please provide enough cash for the transaction.");
            
        }
        String shopAgain = JOptionPane.showInputDialog("Do you want to shop again? (yes/no)");
            wantsToShopAgain = shopAgain != null && shopAgain.equalsIgnoreCase("yes");
        } while (wantsToShopAgain);
    }
}

        