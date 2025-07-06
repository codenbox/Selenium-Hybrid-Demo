# 🧪 Selenium Hybrid Framework Demo

This project is a **Selenium WebDriver Hybrid Framework** built with Java and TestNG. It follows key design principles like **Page Object Model (POM)**, **data-driven testing**, and uses **Maven** for build management. Ideal for learning, testing, and scaling real-world UI automation.

---

## 🚀 Features

- Selenium WebDriver + Java + TestNG
- Page Object Model (POM) structure
- Data-driven testing with Excel
- Cross-browser execution support
- Logging with Log4j
- Easy integration with CI/CD tools
- Built-in test reports using TestNG and ExtentReports

---

## 📁 Project Structure

Selenium-Hybrid-Demo/
│
├── src/test/java/
│ ├── com.framework.base/ # Base test and WebDriver config
│ ├── com.framework.pages/ # Page classes (POM)
│ ├── com.framework.tests/ # Test classes
│ ├── com.framework.utilities/ # Utility files (Excel, Config)
│
├── test-output/ # TestNG reports
├── config.properties # Test environment config
├── log4j.properties # Logging configuration
├── pom.xml # Maven build file
└── testng.xml # Test suite configuration


---

## 🛠️ Prerequisites

- Java 11 or higher
- Maven 3.6+
- IntelliJ IDEA / Eclipse
- Chrome or Firefox browsers

---

## 📦 Installation & Setup

```bash
# 1. Clone the repo
git clone https://github.com/codenbox/Selenium-Hybrid-Demo.git
cd Selenium-Hybrid-Demo

# 2. Build the project and download dependencies
mvn clean install

# Run tests using TestNG suite
mvn test -DsuiteXmlFile=testng.xml
Note: You can customize test execution by editing testng.xml.

📊 Reports & Logs
✅ TestNG HTML reports → test-output/index.html
📓 Logs are stored in the console (Log4j-enabled)

⚙️ Configurations
-Edit the config.properties file to set:
-Browser type (chrome/firefox)
-Base URL
-Timeout settings
-Path to Excel test data

🔁 Follow me on LinkedIn (https://www.linkedin.com/in/sarifuli/) for more insights- QA & Automation, Mock Interviews and Career Growth content.

### 📌 Next Steps
- Want me to include GitHub badges (build status, license, etc.)?
- Need a `.gitignore` or `.editorconfig` file?
- Want a YouTube video walkthrough link included?

Let me know and I’ll update the README accordingly!







