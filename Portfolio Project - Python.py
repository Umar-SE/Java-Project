# Function to validate the amount_of_phones, assesing if requirements are met
def get_amount_of_phones():
   while True:
       try:
           amount = int(input("Enter the amount of phones (between 5 and 1000 in multiples of 5): "))
           if 5 <= amount <= 1000 and amount % 5 == 0:
               return amount
           else:
               print("Invalid input. Please enter a multiple of 5 between 5 and 1000.")
       except ValueError:
           print("Invalid input. Please enter a  value.")
# Function to get the phone type and return the price
def get_phone_type():
   phone_types = {
       "basic": 250,
       "standard": 450,
       "superior": 950
   }
#Levels of phone types chosen diffrentiates the final cost
   while True:
       phone_type = input("Enter the type of phone level(basic, standard, superior): ").lower()
       if phone_type in phone_types:
           return phone_type, phone_types[phone_type]
       else:
           print("Invalid phone type. Please choose between basic, standard, or superior.")
# Function to get the setup option and return the price
def get_setup_option():
   setup_options = {
       "A": 30,
       "B": 50
   }
   while True:
       setup_option = input("Choose a setup option (A or B): ").upper()
       if setup_option in setup_options:
           return setup_option, setup_options[setup_option]
       else:
           print("Invalid setup option. Please choose either A or B.")
# Function to calculate the total final cost which combines the amount of phones, type of phone, setup option and VAT.
def calculate_final_cost(phone_count, phone_price, setup_price):
   initial_cost = (phone_count * phone_price) + (phone_count * setup_price)
   vat = initial_cost * 0.2
   return initial_cost + vat
# Main program
def main():
   # Get customer details for final reciept 
   company_name = input("Enter your company name: ")
   company_contact = input("Enter your phone number: ")
   # Get order details for reciept in the output
   phone_amount = get_amount_of_phones()
   phone_type, phone_price = get_phone_type()
   setup_option, setup_price = get_setup_option()
   # Calculate the final cost with VAT, VAT is an additional cost of 20%
   final_cost = calculate_final_cost(phone_amount, phone_price, setup_price)
   # Output the order details
   print("\nOrder Summary:")
   print(f"Company name: {company_name}")
   print(f"Company contact: {company_contact}")
   print(f"Amount of phones: {phone_amount}")
   print(f"Phone Type: {phone_type.capitalize()}")
   print(f"Setup Option: {setup_option}")
   print(f"Final Cost (with 20% VAT): £{final_cost:.2f}")

if __name__ == "__main__":
   main()

