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

1. Association automatique d'un compte courant (solde 20£) à chaque
   création client

2. Association ultérieure d'un compte épargne à un client

3. Virements bancaires de compte à compte (courant ou épargne)

## Limitation et bugs

/!\ Cette version est hautement expérimentale et de nombreux bugs
restent à corriger /!\
- Affectation un client a un conseiller
- Pas de gestion de patrimoine
- Pas de comptes entreprise
- etc.

## Télechargement et Configuration 
----------------------------------
**Préparation de l'environement**

**I-Outils de développement**

***GIT***

- Téléchargement de GIT depuis ce lien : `https://git-scm.com/downloads`.
- Exécuter le fichier téléchargé.
- Lancer la commande suivante: `git config --global user.name "nomUtilisateur"`.
- Lancer la commande suivante: `git config --global user.email "nom@gmail.com"`.

***JDK***

1. Téléchargement de JDK version 8 depuis ce lien `:https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html`

Remarque 1 : si votre machine est de type 32 bit, vous devez choisir jdk-8u11-windows-i586.exe.

Remarque 2 : la version 32 bit fonctionne sur un Système Windows 32 bit ou 64 bit.

2. Executer le fichier télécharger.

***Configuration de la variable d'environement:***

  => Appuyer sur les deux touches (‘icône windows’+ touche E) pour avoir l’explorateur windows.

  => puis cliquer droite sur l’icone ‘Ordinateur’ et sélectionner ‘propriétés’.
  
  => puis cliquer sur le lien ‘paramètres systèmes avancés’.
 
  => Cliquer sur le bouton ‘variable d’environnement’.
  
  => Vous allez  obtenir une  fenêtre " variables d’environnement", contenant une partie ‘user’ et une partie ‘système’.

  => Dans la partie ‘user’, cliquer sur ‘nouvelle’ ,puis Ajouter une nouvelle variable nommée: "JAVA_HOME".
 
  => puis associer la valeur Ex (C:\Program Files\Java\jdk-12.0.1\bin) finalement appuyer sur ok .
 
  => Dans variable système choisissez le variable path et cliquer sur modifer puis a la fin de la ligne ajouter: ;%JAVA_HOME% et appuyer      sur ok.

  => pour tester l'installation ouvrir une ligne de commande cmd et taper la commande suivante: `java -version`.

***Maven***

1. Téléchargement de Maven  depuis ce lien :`http://maven.apache.org/download.cgi`


 => Appuyer sur les deux touches(touche Windows + E) / clique droit sur Ordinateur / Propriétés / Paramètre système avancés / Bouton     Variable d’environnement / Dans la partie ‘user’, / Nouvelle…

 => Ajouter le variable d’environnement utilisateur sur le nom de M3_HOME et la valeur du chemin du répertoire apache-maven-3.6.1 (Ex:       C:\apache-maven-3.6.1\bin) et appuyer sur ok .

 => Dans variable système choisir le variable path et cliquer sur modifer puis a la fin de la ligne ajouter: ;%M3_HOME% et appuyer sur       ok

 => Pour tester l'installation ouvrir une ligne de commande cmd puis taper la commande suivante: `mvn -v`

***Ide_Eclispe_et_Spring_Boot***

	1. Telechargement eclipse depuis ce lien: 
	https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-09/R/eclipse-inst-win64.exe.

	2. Executer le fichier téléchargé.
	
	3. Ouvrir Ide Eclipse ,dans le "nav bar" cliquer sur Help puis sur "Eclipse Marketplace" . Une petite fenêtre qui s'affiche , 		dans la barre de recherche taper "sts" puis choisir : " Spring Tools 3 (Standalone Edition) 3.9.10.RELESE". puis click sur 		INSTALL.

***NodeJS_et_nmp***

	1. téléchargement de Nodejs depuis ce lien : `https://nodejs.org/en/download/`.
	2. Executer le fichier téléchargé.
	3. Verifier l'installation de nodejs on utilise cette commande depuis cmd `node -v`.
	4. Verifier l'installation de npm on utilise cette commande depuis cmd`npm -v`.

***Angular***

	1. Lancez la commande suivante dans la ligne de commande cmd: `npm install -g @angular/cli`.
	2. Verifier la version de angular on utilise cette commande `ng version`.

 **II-Récupération du porojet depuis github**

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
**III- Partie front-end** 


-Aller au chemin suivant `"\ProxiBanqueV4\proxi-client"` et lancer la ligne de commande cmd et tapez la commande suivant (il faut que la connexion internet soit assuré)

`$ npm install`
c'est pour installer les nodes modules.

## Structure du projet

Le projet devra être rendu sur github avant la date 23 octobre 2019.
Le projet devra être envoyé sous la forme d'une archive `ProxiBanqueV4.zip` contenant un fichier **README.md** avec le nom de group D.
L'archive ne contiendra que des :

 * répertoires
 * fichiers `.mdj`
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

### Exemple API de Client

Method | Path              | Description                        |
-------|-------------------|------------------------------------|
GET    | /clients          | recuperer liste des clients        |
GET    | /clients/{code}   | afficher les information de client |
POST   | /clients          | ajouter un nouveau client          |
PUT    | /clients          | modifier un client existe          |
DELETE | /clients/{code}   | supprimer un client par son code   |


*********************************************************************************

## Exécution de l'application
------------------------------

Compiler
--------

Pour compiler le projet, vous avez besoin de la commande Maven.

`$ mvn compiler`

pour executer l'application tapez le code suivant sur l'invite de commande:

`$ mvn spring-boot:run`

Pour lancer l'application sur le navigateur il faut taper le code suivant sur l'invite de commande:

`$ ng serve --open`

## Fonctionement de l'application
---------------------------------
la page qui s'affiche en premier lieu c'est la page d'authentification:

- Pour se connecter en tant que profil conseiller entrer => identifiant:   chaimaa    et mot de passe:    chaimaa123
- Pour se connecter en tant que profil gérant entrer => identifiant:  fatiz et mot de passe:   fatiz123
- Pour se connecter en tant que profil modérateur entrer => identidiant:  nabila et mot de passe:   nabila123


