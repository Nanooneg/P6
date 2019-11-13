# P6 - DA JAVA - OpenClassrooms - Arnaud Laval


## Présentation :
### Ce dépôt contient le code source d'une application web.
Cette application web a été développée dans le cadre du projet n°6 du parcours DA-JAVA.

## Développement :
### Cette application a été développée avec IntelliJ IDEA Ultimate 2019.2.4 et la Java JDK 12 (12.0.2).
C'est une architecture Maven multi-modules. J'ai utilisé les framework Spring (Spring-core pour l'inversion de contrôle et l'injection
de dépendance, Spring-data pour l'accées aux données et Spring-webmvc pour la gestion des parties vues et controller)
et Hibernate pour la partie persistence des entités.

## Installation :
### Si ce n'est pas encore fait, importez l'ensemble du répertoire P6 depuis GitHub.
Cette application est configurée pour fonctionner avec une base de donnée PostgreySql.

Vous devez télécharger et installer PostgreySql (https://www.postgresql.fr/) puis créer une base de donnée.

Rendez-vous dans le fichier de configuration /escalade/escalade-webapp/src/main/resources/persistence/hibernate.properties
et changer les paramètres d'accés qui vous sont propres : L'adresse de la bdd, votre nom d'utilisateur et votre mot de passe.

Servez-vous maintenant des script de création de table présent dans le fichier joint (table) et si vous le souhaitez vous 
trouverez dans le dernier fichier (insert) un jeu de données de test. Si vous lancez l'application (comme décris ci-dessous) une 
première fois sans avoir créé les tables avec les script fournis, hibernate les créera automatiquement.

## Lancement :
Vous pouvez lancer un serveur web depuis votre IDE (j'ai utilisé TOMCAT9) et vous rendre sur http://localhost:8080/ dans 
votre navigateur (ce sont les paramètre par défault, à vérifier dans votre configuration de TOMCAT).

## Version 1.0-SNAPSHOT

## Auteur : NanoO

