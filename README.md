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

## Livrables

- Le projet Eclipse `ProxiBanqueV4`, qui constitue un projet
  Maven
  
- Le projet Angular `proxi-client`, 

- Un dossier de documentation Javadoc qui contient la documentation du
  projet au format HTML

- Présents dans le dossier `./uml`, les exports graphiques :

  + d'un diagramme de classe
  + d'un diagramme de cas d'utilisation
  + d'un diagramme de déploiement

## Structure du projet

Le projet devra être rendu sur github avant la date 23 octobre 2019.
Le projet devra être envoyé sous la forme d'une archive `ProxiBanqueV4.zip` contenant un fichier **README.md** avec le nom de group D.
L'archive ne contiendra que des :

 * répertoires
 * fichiers `.java`
 * fichiers `.sh`
 * fichiers `.md`
 * fichiers `.html`
 * fichiers `.css`
 * fichiers `.ts
 * fichiers `.json`

Le contenu de projet sera structuré comme suit :
```
ProxiBanqueV4
| +-- Spring Elements/
| +-- src/main/java/
|  |   +-- ma.jit.proxibanque.entities/
|  |       +-- (*.java)
| +-- src/main/resources/
|  |       +-- (application.properties)
| +-- src/test/java/
|     +-- ma.jit.proxibanque
|  |      +-- (*.java)
| +-- JRE System Library/
| +-- Maven Dependencies/
| +-- bin/
| +-- proxi-client/
|  |   +-- e2e/
|  |   +-- node-modules/
|  |   +-- src/
|  |       +-- app/
|  |       +-- assets/
|  |       +-- environments/
| +-- src/
| +-- target/
| +-- mvnw.sh
| +-- mvnw.cmd
| +-- pom.xml
| +-- README.md
```


- Libraries :

  Se référer au fichier `pom.xml` situé à la racine du projet pour
  visualiser les dépendances en terme de librairies. Celles-ci sont
  gérées automatiquement par Maven. Les grandes catégories sont :

  + Spring boot
  
  + Spring securite

  + MySQL Connecter

  + JPA

## Telechargement et Configuration 
----------------------------------
I- Recuperer la source

 1) Cloner le projet depuis lien github `"https://github.com/chaimaa09/ProxiBanqueV4.git"`
 
 2) Configuration sur la partie back-end du projet "ProxiBanqueV4"

   * Creation de la base donnee 'proxibanque_v4':
   
   * Base de données MySQL (disponible et configurée avec le logiciel XAMPP). Veillez à ce que celle-ci soit disponible sur le port 3306.

   * Copier le port de mysql et coller dans le fichier application.properties qui se trouve dans ce chemin "ProxiBanqueV4\src\main\resources\application.properties"

	le numero de port se trouve apres 'jdbc:mysql://localhost:' au lieu de 
	mettre 'update' vous mettez 'create' mais juste au niveau du premier lancement du projet.
```
spring.datasource.url = jdbc:mysql://localhost:3306/proxibanque_v4?serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password =
spring.datasource.driverClassName = com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto = update

```
II- Partie front-end 

aller au chemin suivant `"\ProxiBanqueV4\proxi-client"` et lancer la ligne de commandecmd et tapez la commande suivant:

`$ npm install`
 
c'est pour installer les nodes modules.

### API

Method | Path              | Description                        |
-------|-------------------|------------------------------------|
GET    | /clients          | recuperer liste des clients        |
GET    | /clients/{code}   | afficher les information de client |
POST   | /clients          | ajouter un nouveau client          |
PUT    | /clients          | modifier un client existe          |
DELETE | /clients/{code}   | supprimer un client par son code   |


*********************************************************************************

## Installation et exécution
------------------------------


Compiler
--------

Pour compiler le projet, vous avez besoin de la commande Maven.

`$ mvn compiler`

pour executer l'application tapez le code suivant sur l'invite de commande:

`$ mvn spring-boot:run`

Pour lancer l'application sur le navigateur il faut taper le code suivant sur l'invite de commande:

`$ ng serve --open`


**Description générale**
--------
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

1. Association automatique d'un compte courant (solde 20£) à chaque
   création client

2. Association ultérieure d'un compte épargne à un client

3. Virements bancaires de compte à compte (courant ou épargne)

## Limitation et bugs

/!\ Cette version est hautement expérimentale et de nombreux bugs
restent à corriger /!\

- Pas de gestion de patrimoine
- Pas de comptes entreprise
- etc.
