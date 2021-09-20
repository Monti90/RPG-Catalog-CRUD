export interface Game{
    id: number | null;
    name: string;
    description: string;
    price: number;
    publisherID: number;
    userID: number;
    author: string;
    genre: string;
    category: string;
}