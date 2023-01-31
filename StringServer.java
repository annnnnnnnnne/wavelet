import java.io.IOException;
import java.net.URI;
import java.util.*;
class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;
    ArrayList<String> stringAll = new ArrayList<>();
    public String handleRequest(URI url) {
      if (url.getPath().equals("/")) {
          return String.format("");
      // } else if (url.getPath().equals("/increment")) {
      //     num += 1;
      //     return String.format("Number incremented!");
      } else {
          System.out.println("Path: " + url.getPath());
          if (url.getPath().contains("/add")) {
              String[] parameters = url.getQuery().split("=");
              System.out.println(parameters);
              if (parameters[0].equals("s")) {
                  // num += Integer.parseInt(parameters[1]);
                  stringAll.add(parameters[1]);
                  // for(int i = 0; i < stringAll.size(); i++){
                  //   System.out.println(stringAll.get(i));
                  // }
                  return String.format("%s\n%s",stringAll.get(0),stringAll.get(1));
              }
          }
          return "404 Not Found!";
      }
  } 

//     public String handleRequest(URI url) {
//         if (url.getPath().equals("/")) {
//             return String.format("");
//         }
//         // } else if (url.getPath().equals("/increment")) {
//         //     num += 1;
//         //     return String.format("Number incremented!");
//         // } 
//         else if{
//             System.out.println("Path: " + url.getPath());
//             if (url.getPath().contains("/add-message")) {
//                 String[] parameters = url.getQuery().split("=");
//                 if (parameters[0].equals("s")) {
//                     // num += Integer.parseInt(parameters[1]);
//                     stringAll.add(parameters[1]);
//                     for(int i = 0; i < stringAll.size();i++){
//                       System.out.println(stringAll.get(i));
//                     }
                    
//                 }
//             return String.format("Number increased by %s! It's now %d", parameters[1], num);
//           }
//             }else
//             return "404 Not Found!";
//     }
// }


}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
