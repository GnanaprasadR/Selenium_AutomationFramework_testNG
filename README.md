# E-Commerce Order Automation with Selenium

A Selenium WebDriver automation script that simulates an end-to-end order placement flow on a demo e-commerce web application. Built in Java, this project covers product browsing, cart management, and checkout — core flows tested in any QA project involving a shopping platform.

---

## What This Project Tests

The automation script covers a complete **online shopping order journey**:

| Step | Scenario |
|---|---|
| 1 | Launch the e-commerce application and navigate to the product catalogue |
| 2 | Search or browse for a product |
| 3 | Add product to shopping cart |
| 4 | Proceed to checkout |
| 5 | Enter shipping/billing details |
| 6 | Place the order and validate order confirmation |

---

## Tech Stack

| Tool | Purpose |
|---|---|
| Java | Core language |
| Selenium WebDriver | Browser automation |
| Maven | Build and dependency management |

---

## Prerequisites

- Java JDK 8 or above installed
- Maven 3.6+ installed
- Google Chrome or Firefox browser installed
- Matching WebDriver binary available on system PATH (or via WebDriverManager)

---

## Project Structure

```
Automation-Selenium-Java-Project1/
├── OnlineShopping/             # Core automation scripts for the shopping flow
│   └── src/
│       └── main/java/
│           └── tests/          # Test classes for each order step
├── README.md
```

---

## How to Run

**Clone the repository:**
```bash
git clone https://github.com/GnanaprasadR/Automation-Selenium-Java-Project1.git
cd Automation-Selenium-Java-Project1
```

**Navigate to the project directory and run:**
```bash
cd OnlineShopping
mvn clean test
```

---

## Key Automation Concepts Demonstrated

- **End-to-End User Flow Testing** — chaining multiple UI interactions across several pages
- **Form Automation** — filling shipping and billing forms programmatically
- **Navigation Assertions** — validating redirects and confirmation messages post-order
- **Locator Strategies** — XPath, CSS Selector, and ID-based element identification

---

## Author

**Gnanaprasad R**
SDET | 10 years of experience in software testing
[LinkedIn](https://www.linkedin.com/in/gnanaprasad-r-556082b7) • [GitHub](https://github.com/GnanaprasadR)
