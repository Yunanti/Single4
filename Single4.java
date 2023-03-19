/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author yunan
 */
public class Single4 {
//    deklarasi variable
    String Key;
    ArrayList<String> AllUrl;
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Cari: ");
        Single4 kunci = new Single4();
        kunci.Key = keyboard.nextLine();
        String url = "https://www.google.com/search?q=" + kunci.Key;
        
//        String UserAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) "
//            + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 "
//            + "Safari/537.36";
        System.out.println("URL Induk: ");
        Induk(1, url);
        System.out.println("URL Anak: ");
//        kunci.AllUrl = new ArrayList<String>();
//        AllLink list = new AllLink();
//        System.out.println(AllLink());
//        for(int i = 0; i < kunci.AllUrl.size(); i++){
//            
//        }
    }
    
    private static void Induk(int level, String urlInduk){
        if(level <= 5){
            Single4 allLink = new Single4();
//            allLink.AllUrl = AllUrl;
            Document doc = requestInduk(urlInduk);
            
            if(doc != null){
                for(Element link : doc.select("div.yuRUbf > a")){ //untuk mengambil URL Induk
                    String next_link = link.absUrl("href");
                    if(allLink.AllUrl.contains(next_link)==false){
                        Induk(level++, next_link);
//                        System.out.println(link);
                    }
                }
                    
            }
        }
    }
    
    private static Document requestInduk(String urlInduk){
        try{
            
            System.out.println("URL Induk: ");
            Connection con = Jsoup.connect(urlInduk);
            Document doc = con.get();
//            System.out.println(con);
            
            if(con.response().statusCode()==200){
                System.out.println("Link: " + urlInduk);
                System.out.println(doc.title());
                AllLink(urlInduk);
                return doc;
            }
            
            return null;
        }
        catch(IOException e){
            return null;
        }
    }
    
    public static ArrayList<String> AllLink(String urlInduk)
    {
        ArrayList<String> link = new ArrayList<String>();
        link.add(urlInduk);
 
        return link;
    }
    
    private static void Anak(int level, String urlInduk,  ArrayList<String>AllUrl){
        if(level <= 5){
            Single4 allLink = new Single4();
            allLink.AllUrl = AllUrl;
            Document doc = requestAnak(urlInduk, AllUrl);
            
            if(doc != null){
                for(Element link : doc.select("div.yuRUbf > a")){ //untuk mengambil URL Induk
                    String next_link = link.absUrl("href");
                    if(allLink.AllUrl.contains(next_link)==false){
                        Anak(level++, next_link, AllUrl);
//                        System.out.println(link);
                    }
                }
                    
            }
        }
    }
    
    private static Document requestAnak(String urlInduk, ArrayList<String> AllUrl){
        try{
            
            System.out.println("URL Induk: ");
            Connection con = Jsoup.connect(urlInduk);
            Document doc = con.get();
//            System.out.println(con);
            
            if(con.response().statusCode()==200){
                System.out.println("Link: " + urlInduk);
                System.out.println(doc.title());
                AllUrl.add(urlInduk);
                return doc;
            }
            
            return null;
        }
        catch(IOException e){
            return null;
        }
    }
}
