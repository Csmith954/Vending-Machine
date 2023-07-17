# Vending Machine

**Project Description:** Vending Machine is a command-line interface (CLI) program built in Java. It reads a text file to input the inventory for the program, allowing users to view the inventory, add funds, make change from their balance, and make purchases. The program also features a secret admin menu that allows users to view a transaction report. Additionally, there's an easter egg that simulates shaking the vending machine and spits out funny movie quotes.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Technologies Used](#technologies-used)

## Installation

To run the Vending Machine program locally, please follow these steps:

1. Clone the repository to your local machine:
   ```
   git clone https://github.com/your-username/vending-machine.git
   ```

2. Navigate to the project directory:
   ```
   cd vending-machine
   ```

3. Compile the Java source code:
   ```
   javac Main.java
   ```

4. Run the program:
   ```
   java Main
   ```

## Usage

To use the Vending Machine program, follow these steps:

1. Compile and run the Java source code as mentioned in the installation steps.

2. The program will read the inventory from a text file and display the available items along with their prices and quantities.

3. Use the available commands to interact with the vending machine:
   - View the inventory.
   - Add funds.
   - Make change from your balance.
   - Make a purchase, enter the item code (e.g., A1, B2) and press enter.

4. If you want to access the secret admin menu, enter 's' on the main menu.

5. Try trigger the easter egg, hint it might have to do with (k)icking the machine ;).

## Features

- View Inventory: Users can view the inventory of the vending machine, which displays available items, their prices, and quantities.
- Add Funds: Users can add funds to their balance to make purchases.
- Make Change: Users can make change from their balance.
- Make Purchases: Users can select an item and purchase it, deducting the appropriate amount from their balance.
- Secret Admin Menu: Provides access to a menu for administrators, allowing them to view a transaction report.
- Easter Egg: Simulates shaking the vending machine and displays funny movie quotes.

## Technologies Used

- Java: Programming language used to build the Vending Machine program.

## Disclaimer

Please note that the Vending Machine program is a CLI application and does not have a graphical user interface. All interactions are performed through the command-line interface.
