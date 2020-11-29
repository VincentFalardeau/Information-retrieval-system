//https://mkyong.com/swing/java-swing-jfilechooser-example/

class Mot{
    String nom;
    int frequence;
}

class Document{
    String nom;
    int frequence;
}

class DocumentExt extends Document{
    ArrayList<Mot> mots;
}

class MotExt extends Mot{
    Document[] docs = new Document[list2.length];
    ArrayList<Document> docs;
}

ArrayList<MotExt> list;

JFileChooser j = new JFileChooser;
File[] files = j.files;

DocumentExt[] list2 = new DocumentExt[files.length];
