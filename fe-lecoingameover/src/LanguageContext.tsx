import React, { createContext, useState, useContext, ReactNode } from "react";

export interface TranslationKeys {
    portfolioTitle: string;
    home: string;
    about: string;
    projects: string;
    comments: string;
    adminComments: string;
    hello: string;
    logout: string;
    login: string;
    aboutTitle: string;
    aboutDescription: string;
    skills: string;
    hobbies: string;
    perseverance: string;
    respect: string;
    collaboration: string;
    java: string;
    csharp: string;
    htmlcss: string;
    jsreact: string;
    sql: string;
    git: string;
    projectManagement: string;
    gaming: string;
    workout: string;
    volleyball: string;
    iceSkating: string;
    jogging: string;
    cvPrompt: string;
    downloadCV: string;
    welcomeTitle: string;
    welcomeMessage: string;
    projectsShowcase: string;
    skillsSection: string;
    hobbiesSection: string;
    commentsSection: string;
    cvNote: string;
    loginTitle: string;
    usernameLabel: string;
    usernamePlaceholder: string;
    passwordLabel: string;
    passwordPlaceholder: string;
    loginButton: string;
    loginError: string;
    projectsTitle: string;
    project1Title: string;
    project1Description: string;
    project2Title: string;
    project2Description: string;
    project3Title: string;
    project3Description: string;
    project4Title: string;
    project4Description: string;
    githubLink: string;
    publicCommentsTitle: string;
    nameColumn: string;
    messageColumn: string;
    timestampColumn: string;
    addCommentTitle: string;
    commentPlaceholder: string;
    submitButton: string;
    loginRequired: string;
    commentUnderReview: string;
    manageCommentsTitle: string;
    actionsColumn: string;
    approveButton: string;
    deleteButton: string;
    confirmDelete: string;
    deleteSuccess: string;
    deleteError: string;
    approveSuccess: string;
    approveError: string;
    redirectError: string;
    footerTitle: string;
    footerDescription: string;
    contact: string;
    allRightsReserved: string;
    languageSwitch: string;
    enterNameAndMessage: string;
}


export const translations: Record<"en" | "fr", TranslationKeys> = {
    en: {
        portfolioTitle: "My Portfolio",
        home: "Home",
        about: "About Me",
        projects: "Projects",
        comments: "Comments",
        adminComments: "Admin Comments",
        hello: "Hello",
        logout: "Logout",
        login: "Login",
        aboutTitle: "About Me",
        aboutDescription: "My name is Thomas Lemay, I’m a third-year student at Champlain College in Computer Science. I’m a perseverant and hard-working student who likes to pursue his goals with determination. Ever since I was a child, the technological world was something that I was really passionate about. This passion has followed me since my youth which is why I chose to get a career in this industry. I’m autonomous and have good front-end and back-end coding experiences. I coded microservice based applications in Java  and I used docker in multiple school projects. These projects allowed me to sharpen my team working skills and made me realize that I love to work and collaborate in a team.\n",
        skills: "Skills",
        hobbies: "Hobbies",
        perseverance: "Persevering",
        respect: "Respectful",
        collaboration: "Collaboration",
        java: "Java",
        csharp: "C#",
        htmlcss: "HTML/CSS",
        jsreact: "JavaScript/React",
        sql: "SQL (MySQL, MongoDB, Oracle, MicrosoftSQL)",
        git: "Git/GitHub",
        projectManagement: "Project Management",
        gaming: "Gaming",
        workout: "Working Out",
        volleyball: "Volleyball",
        iceSkating: "Ice Skating",
        jogging: "Jogging",
        cvPrompt: "If you want to know more about me, you can download my CV:",
        downloadCV: "Download CV",
        welcomeTitle: "Welcome to My Portfolio",
        welcomeMessage: "I’m Thomas Lemay, a passionate Computer Science student at Champlain College Saint-Lambert.",
        projectsShowcase: "🔹 Projects: A showcase of my programming work.",
        skillsSection: "🔹 Skills: My expertise as a programmer.",
        hobbiesSection: "🔹 Hobbies: What I do when I'm not coding.",
        commentsSection: "🔹 Comments: Feel free to leave comments to let me know what you think!",
        cvNote: "Note: You can access my CV in the About Me page.",
        loginTitle: "Login",
        usernameLabel: "Username",
        usernamePlaceholder: "Enter your username",
        passwordLabel: "Password",
        passwordPlaceholder: "Enter your password",
        loginButton: "Login",
        loginError: "Invalid username or password",
        projectsTitle: "Projects",
        project1Title: "Le Coin Game Over",
        project1Description: "A website for a local game store featuring authentication, payment processing, and product browsing, built with Java and React.",
        project2Title: "Champlain Pet Clinic",
        project2Description: "A multi-service microservices-based application built using Spring Boot, Scrum, version control, and CI/CD.",
        project3Title: "Pirate Ship Defense - Unity",
        project3Description: "A pirate-themed tower defense game inspired by Bloons TD, developed in Unity using C#.",
        project4Title: "Resume Builder",
        project4Description: "A .NET application that allows users to build and customize resumes, developed in C#.",
        githubLink: "View on GitHub",
        publicCommentsTitle: "Public Comments",
        nameColumn: "Name",
        messageColumn: "Message",
        timestampColumn: "Timestamp",
        addCommentTitle: "Add a Comment",
        commentPlaceholder: "Write your comment here...",
        submitButton: "Submit",
        loginRequired: "You must be logged in to submit a comment.",
        commentUnderReview: "Your comment is under review by the admin and will be published soon.",
        manageCommentsTitle: "Manage Comments",
        actionsColumn: "Actions",
        approveButton: "Approve",
        deleteButton: "Delete",
        confirmDelete: "Are you sure you want to delete this comment?",
        deleteSuccess: "✅ Comment deleted successfully.",
        deleteError: "❌ Failed to delete comment.",
        approveSuccess: "✅ Comment approved successfully.",
        approveError: "❌ Failed to approve comment.",
        redirectError: "Unauthorized. Redirecting to homepage...",
        footerTitle: "Thomas Lemay",
        footerDescription: "Computer Science Student at Champlain College Saint-Lambert",
        contact: "Contact",
        allRightsReserved: "© {year} Thomas Lemay. All rights reserved.",
        languageSwitch: "Switch Language",
        enterNameAndMessage: "Please enter both your name and message!"
    },
    fr: {
        portfolioTitle: "Mon Portfolio",
        home: "Accueil",
        about: "À propos de moi",
        projects: "Projets",
        comments: "Commentaires",
        adminComments: "Commentaires Admin",
        hello: "Bonjour",
        logout: "Se déconnecter",
        login: "Se connecter",
        aboutTitle: "À propos de moi",
        aboutDescription: "Mon nom est Thomas Lemay, je suis étudiant de troisième année au Collège Champlain en informatique. Je suis un étudiant persévérant et travailleur qui aime poursuivre ses objectifs avec détermination. Depuis mon enfance, le monde technologique m’a toujours passionné.   et c’est pourquoi j’ai choisi de faire carrière dans cette industrie. Je suis autonome et j’ai de bonnes expériences en programmation front-end et back-end. J’ai coder des applications basées sur une architecture de microservices en Java et j’ai utilisé Docker et Spring Boot dans plusieurs projets scolaires. Ces projets m’ont permis d’affiner mes compétences en travail d’équipe et m’ont fait réaliser que j’adore travailler et collaborer avec les autres.",
        skills: "Compétences",
        hobbies: "Passions",
        perseverance: "Persévérant",
        respect: "Respectueux",
        collaboration: "Collaboration",
        java: "Java",
        csharp: "C#",
        htmlcss: "HTML/CSS",
        jsreact: "JavaScript/React",
        sql: "SQL (MySQL, MongoDB, Oracle, MicrosoftSQL)",
        git: "Git/GitHub",
        projectManagement: "Gestion de projet",
        gaming: "Jeux vidéo",
        workout: "Musculation",
        volleyball: "Volleyball",
        iceSkating: "Patinage sur glace",
        jogging: "Jogging",
        cvPrompt: "Si vous voulez en savoir plus sur moi, vous pouvez télécharger mon CV :",
        downloadCV: "Télécharger le CV",
        welcomeTitle: "Bienvenue sur Mon Portfolio",
        welcomeMessage: "Je suis Thomas Lemay, un étudiant passionné en informatique au Collège Champlain Saint-Lambert.",
        projectsShowcase: "🔹 Projets : Mes différents projets de programmation.",
        skillsSection: "🔹 Compétences : Mon expertise en tant que programmeur.",
        hobbiesSection: "🔹 Passions : Ce que je fais quand je ne code pas.",
        commentsSection: "🔹 Commentaires : N'hésitez pas à me laisser un commentaire !",
        cvNote: "Remarque : Vous pouvez accéder à mon CV sur la page À propos de moi.",
        loginTitle: "Connexion",
        usernameLabel: "Nom d'utilisateur",
        usernamePlaceholder: "Entrez votre nom d'utilisateur",
        passwordLabel: "Mot de passe",
        passwordPlaceholder: "Entrez votre mot de passe",
        loginButton: "Se connecter",
        loginError: "Nom d'utilisateur ou mot de passe invalide",
        projectsTitle: "Projets",
        project1Title: "Le Coin Game Over",
        project1Description: "Un site Web pour une boutique de jeux locale avec authentification, paiement en ligne et navigation produit, développé avec Java et React.",
        project2Title: "Champlain Pet Clinic",
        project2Description: "Une application microservices multi-services construite avec Spring Boot, Scrum, gestion de versions et CI/CD.",
        project3Title: "Pirate Ship Defense - Unity",
        project3Description: "Un jeu de tower defense sur le thème des pirates inspiré de Bloons TD, développé en Unity avec C#.",
        project4Title: "Resume Builder",
        project4Description: "Une application .NET qui permet aux utilisateurs de créer et de personnaliser des CV, développée en C#.",
        githubLink: "Voir sur GitHub",
        publicCommentsTitle: "Commentaires publics",
        nameColumn: "Nom",
        messageColumn: "Message",
        timestampColumn: "Horodatage",
        addCommentTitle: "Ajouter un commentaire",
        commentPlaceholder: "Écrivez votre commentaire ici...",
        submitButton: "Soumettre",
        loginRequired: "Vous devez être connecté pour soumettre un commentaire.",
        commentUnderReview: "Votre commentaire est en attente de validation par l'administrateur et sera publié bientôt.",
        manageCommentsTitle: "Gérer les commentaires",
        actionsColumn: "Actions",
        approveButton: "Approuver",
        deleteButton: "Supprimer",
        confirmDelete: "Êtes-vous sûr de vouloir supprimer ce commentaire ?",
        deleteSuccess: "✅ Commentaire supprimé avec succès.",
        deleteError: "❌ Échec de la suppression du commentaire.",
        approveSuccess: "✅ Commentaire approuvé avec succès.",
        approveError: "❌ Échec de l'approbation du commentaire.",
        redirectError: "Non autorisé. Redirection vers la page d'accueil...",
        footerTitle: "Thomas Lemay",
        footerDescription: "Étudiant en informatique au Collège Champlain Saint-Lambert",
        contact: "Contact",
        allRightsReserved: "© {year} Thomas Lemay. Tous droits réservés.",
        languageSwitch: "Changer la langue",
        enterNameAndMessage: "Entrez un nom ainsi qu'un message s'il vous plait"
    },
};






// Define context type
interface LanguageContextType {
    language: "en" | "fr";
    toggleLanguage: () => void;
    t: (key: keyof TranslationKeys) => string;
}

// Create the context
const LanguageContext = createContext<LanguageContextType | undefined>(undefined);

// Define provider props type
interface LanguageProviderProps {
    children: ReactNode;
}

// Language Provider Component
export const LanguageProvider: React.FC<LanguageProviderProps> = ({ children }) => {
    const [language, setLanguage] = useState<"en" | "fr">(
        (localStorage.getItem("lang") as "en" | "fr") || "en"
    );

    const toggleLanguage = () => {
        const newLang = language === "en" ? "fr" : "en";
        setLanguage(newLang);
        localStorage.setItem("lang", newLang);
    };

    // Translation function
    const t = (key: keyof TranslationKeys) => translations[language][key];

    return (
        <LanguageContext.Provider value={{ language, toggleLanguage, t }}>
            {children}
        </LanguageContext.Provider>
    );
};

// Custom hook for using the language context
export const useLanguage = (): LanguageContextType => {
    const context = useContext(LanguageContext);
    if (!context) {
        throw new Error("useLanguage must be used within a LanguageProvider");
    }
    return context;
};
