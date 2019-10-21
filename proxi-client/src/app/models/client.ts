export class Client{
    code:number;
    nom:string;
    prenom: string;
    adresse: string;
    email: string;
    ville: string;
    codePostale: string;
    compteCourant: {
        numCompte: number,
        solde: number,
        dateCreation: Date
    };
    compteEpargne: {
        numCompte: number,
        solde: number,
        dateCreation: Date
    }; 
} 