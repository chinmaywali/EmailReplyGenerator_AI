
# ✨ AI-Powered Email Generator & Chrome Extension  

## 🚀 Overview  
The **AI-Powered Email Generator & Chrome Extension** simplifies email writing by generating well-structured messages instantly.  

This project includes:  
✅ **A Full-Stack Web Application** – Built with **React.js** (frontend) and **Spring Boot** (backend).  
✅ **A Chrome Extension** – Integrates with **Gmail & Outlook** for quick email drafting.  
✅ **AI Assistance** – Uses **Gemini API** to enhance email content generation.  
✅ **PostMan** - Tested using Postman for API validation.

With a **clean UI** and **one-click email generation**, this tool is designed for **efficiency and convenience**. 🚀  

---

## 🛠️ Tech Stack  

### 🧑‍💻 Backend (Spring Boot)  
- **Spring Boot** – RESTful API for email generation.  
- **Spring Data JPA** – For database interactions (future enhancement).  
- **Maven** – Dependency management.  
- **Lombok** – Reduces boilerplate code.  
- **Gemini API** – Assists in generating email content.
- **Postman** – API testing and validation.


### 🌐 Frontend (React.js)  
- **React 18** – For building the UI.  
- **Vite** – Faster development.  
- **Axios** – API communication.  

### 🧩 Chrome Extension   
- **JavaScript & HTML** – Lightweight and responsive.  
- **Axios** – Backend communication.  

---

## 🎯 Features  

✅ **Instant Email Generation** – Quickly draft emails.  
✅ **Different Writing Styles** – Formal, Casual, Professional, etc.  
✅ **One-Click Copy & Paste** – Seamless workflow integration.  
✅ **Chrome Extension** – Works directly inside Gmail & Outlook.  
✅ **RESTful API Integration** – Backend communication with React & Chrome extension.  

🔹 **Web App Features**  
- Simple UI for generating emails.  
- Copy & paste functionality.  

🔹 **Chrome Extension Features**  
- Works within **Gmail & Outlook**.  
- Pop-up UI for instant email generation.  
- Communicates with the backend via API.  

---

## 📂 Project Structure  

```
AI-Email-Generator/
|
│── backend/ (Spring Boot App)
│   ├── src/main/java/com/ai/emailgenerator/
│   │   ├── controllers/  # API Controllers
│   │   ├── services/  # Business Logic
│   │   ├── models/  # Entity Models
│   │   ├── repositories/  # Database Interactions
│   │   ├── EmailGeneratorApplication.java  # Main Application
│   ├── src/main/resources/application.properties
│   ├── pom.xml
|
│── frontend/ (React App)
│   ├── src/
│   │   ├── components/
│   │   │   ├── EmailForm.js
│   │   │   ├── EmailOutput.js
│   │   ├── App.js
│   │   ├── index.js
│   ├── package.json
|
│── chrome-extension/
│   ├── manifest.json  # Chrome extension config
│   ├── popup.html  # UI for extension
│   ├── popup.js  # Frontend logic
│   ├── background.js  # Background script
|
│── README.md
|
│── .gitignore
```

---

## ⚙️ Setup Instructions  

### 💻 Backend Setup (Spring Boot)  

1️⃣ Clone the repository:  
```bash
git clone https://github.com/chinmaywali/AI-Email-Generator.git
```
2️⃣ Navigate to the backend folder:  
```bash
cd backend
```
3️⃣ Add your **Gemini API Key** in `application.properties`:  
```
GEMINI_API_KEY=your_api_key_here
```
4️⃣ Build and run the Spring Boot app:  
```bash
mvn spring-boot:run
```
5️⃣ The backend will be available at:  
```
http://localhost:8080
```

### 🎨 Frontend Setup (React)  

1️⃣ Open another terminal and navigate to the frontend folder:  
```bash
cd frontend
```
2️⃣ Install dependencies:  
```bash
npm install
```
3️⃣ Start the React app:  
```bash
npm start
```
4️⃣ The frontend will be available at:  
```
http://localhost:3000
```

### 🧩 Chrome Extension Setup  

1️⃣ Navigate to the `chrome-extension` folder.  
```bash
cd chrome-extension
```
2️⃣ Open Chrome and go to:  
```
chrome://extensions/
```
3️⃣ Enable **Developer Mode**.  
4️⃣ Click **Load Unpacked** and select the `chrome-extension` folder.  
5️⃣ The extension will be added to Chrome.  

---

## 🔗 API Endpoints  

### 📌 **AI Email Generation API**  

| Method | Endpoint                   | Description                     | Request Body |
|--------|----------------------------|---------------------------------|--------------|
| **POST**  | `/generate-email`        | Generates an AI-powered email   | `{ "tone": "Professional", "message": "Follow-up on project" }` |

### 📌 **Example API Requests & Responses**  

#### ➤ **Request (Generating an Email)**
```json
{
  "tone": "Formal",
  "message": "Request for rescheduling the meeting"
}
```

#### ➤ **Response**
```json
{
  "email": "Dear [Recipient], I hope this email finds you well. I would like to request a rescheduling of our upcoming meeting..."
}

```

---
## 📮 Postman API Testing  

To **test the AI Email Generation API** in **Postman**, follow these steps:  

1️⃣ Open **Postman**.  
2️⃣ Click on **Import**.  
3️⃣ Click **Raw Text** and paste the following **POST request**:  

### **📌 AI Email Generation API (POST Request)**  
- **Endpoint:** `http://localhost:8090/api/email/generate`  
- **Method:** `POST`  
- **Headers:**  
  - `Content-Type: application/json`  
- **Body (JSON):**  
```json
{
    "emailContent": "Hey there, this is Jhon here. We connected at AWS Summit.. how is your startup going?",
    "tone": "Professional"
}
```
- **Response (Example):**  
```json
{
    "emailContent": "Dear Jhon,\n\nIt was a pleasure connecting with you at the AWS Summit. Thank you for reaching out.\n\nRegarding your question, our startup is progressing well. We've been focusing on [mention a specific area of progress, e.g., developing our MVP, securing seed funding, onboarding new clients].\n\nI'd be happy to share more details when you have time. Perhaps we could schedule a brief call in the coming weeks?\n\nBest regards,\n[Your Name]"
}
```
4️⃣ Click **Send** to test the API and get an AI-generated email response! ✅  

✅ **Available Postman Requests:**  
- **Generate Email** – AI-generated emails based on user input.  
- **Validate API Responses** – Ensure smooth AI integration.  

---

## 🤝 Contributing  
Contributions are welcome! Feel free to **fork** this repo and submit a **pull request**.  


---
