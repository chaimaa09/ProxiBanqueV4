# Projet ProxyBanque JEE-Spring-JPA-Hibernate-Angular

## Objectifs

La banque ProxiBanque souhaite créer une application permettant à ses conseillers de gérer leurs clients et services à forte valeur ajoutée, comme le service de virement compte à compte.
L’application permet à trois  profils de se connecter : 
*	un profil ‘Conseiller’ 
*	un profil ‘Gérant’ (Directeur d’agence) 
*	un profil ‘Parametrage’ (Back Office). 

Ce projet montre un exemple d'application web JEE qui permet de gérer des comptes appartenant à des client. On gère deux types de comptes courant et compte  épargne. 
les etapes qui nous avons suivie pour developper cette applications:

* Créer un projet Spring Boot
* Créer les entités JPA
* Configurer le fichier application.properties
* Créer les interfaces JPA Repository basées sur Spring Data
* Tester la couche DAO
* Créer et Tester la couche métier (Interface et Implémentation)
* Créer la couche.
* Sécuriser l'application en utilisant Spring Security.
 
**Description générale**
------------------------
## Authentification

Aucune requête (sauf pages de login) n’est autorisée sans authentification (système de filtre). L’application fournit donc un système d’authentification permettant de vérifier si le couple login/password correspond à un conseiller ou un gerant présent dans la base de données.
Si oui, l’accès est autorisé pour une session de 60 minutes.

## Gestion de client

1. Création d'un client (nom, prénom, adresse, code postal, ville,
   téléphone)

2. Accès aux informations d'un client

3. lister les information des client de la banque

4. Modification d'un client existant

5. Suppression d'un client et de ses comptes


## Gestion de conseiller

1. Création d'un conseiller (nom, prénom, login, password)

2. Accès aux informations d'un conseiller

3. Affecter un client a un conseiller

## Opérations

1. Association automatique d'un compte courant (solde 20€) à chaque création client

2. Association ultérieure d'un compte épargne à un client

3. Virements bancaires de compte à compte (courant ou épargne)

## Limitation et bugs

/!\ Cette version est hautement expérimentale et de nombreux bugs
restent à corriger /!\
- Affectation un client a un conseiller
- Pas de gestion de patrimoine
- Pas de comptes entreprise
- etc.


## Installation

1) Déziper dans un dossier le fichier "ProxibanqueV4-master.zip" 
2) Copier le fichier "proxi-banque-v4.war"
3) copier "proxi-banque-v4.war" dans le dossier "xampp\tomcat\webapps"
4) Lancer serveur d'application Tomcat 9 et deployer proxi-banque-v4.war

======== Créer la base de donnée MySQL ========

1) Ouvrir Xampp
2) Lancer Apache
3) Lancer MySQL
4) Mettez vous sur le lien "http://localhost/phpmyadmin/"
5) creer une base de donnees avec le nom "proxibanque_v4"
5) cliquer sur l'onglet "Importer" puis choisir un fichier
6) Acceder au dossier "base de donnees" et selectionner le Fichier "proxibanque_v4.sql"
7) Cliquer sur "executer"


======== Lancer l'application ========



1) Acceder au dossier "proxi-client"
2) ouvrez le fichier dans la console et lancez la commande "npm install" et ensuite la commande "npm start"
3) Ouvrez un navigateur internet
4) Tapez dans l'url : http://localhost:4200/login



## Fonctionement de l'application
---------------------------------
la page qui s'affiche en premier lieu c'est la page d'authentification:

- Pour se connecter en tant que profil conseiller entrer => identifiant:   "chaimaa"    et mot de passe:    "chaimaa123"
- Pour se connecter en tant que profil gérant entrer => identifiant:  "fatiz" et mot de passe:   "fatiz123"
- Pour se connecter en tant que profil modérateur entrer => identidiant:  "nabila" et mot de passe:   "nabila123"



 **II-Récupération du projet depuis github**

 1) Cloner le projet depuis lien github `"https://github.com/chaimaa09/ProxiBanqueV4.git"` par cette commande
 
	`git clone https://github.com/chaimaa09/ProxiBanqueV4.git`
 
 2) Configuration sur la partie back-end du projet "ProxiBanqueV4":

  + Pour creer la base de donnee il faut demarer Apache et MySQL (disponible et configurée avec le logiciel XAMPP). Veuillez à ce que       celle-ci soit disponible sur le port 3306. :
  
  + Creatipon de la base de données avec la nomination 'proxibanque_v4'

  + Copier le port de mysql et coller dans le fichier application.properties qui se trouve dans ce chemin            		`"ProxiBanqueV4\src\main\resources\application.properties"`

  + Le numero de port se trouve apres 'jdbc:mysql://localhost:', au lieu de 
	mettre 'update' vous mettez 'create' mais juste au niveau du premier lancement du projet.
```
spring.datasource.url = jdbc:mysql://localhost:3306/proxibanque_v4?serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password =
spring.datasource.driverClassName = com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto = update

```

### Exemple API de Client

Method | Path              | Description                        |
-------|-------------------|------------------------------------|
GET    | /clients          | recuperer liste des clients        |
GET    | /clients/{code}   | afficher les information de client |
POST   | /clients          | ajouter un nouveau client          |
PUT    | /clients          | modifier un client existe          |
DELETE | /clients/{code}   | supprimer un client par son code   |







