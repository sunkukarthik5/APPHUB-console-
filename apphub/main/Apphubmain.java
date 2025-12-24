package apphub.main;

import apphub.service.*;
import java.util.Scanner;

public class Apphubmain
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        AppService service = new AppServiceImpl();

        while (true)
        {
            System.out.println("\n=========================================");
            System.out.println("                 APP HUB          ");
            System.out.println("=========================================");
            System.out.println("0. 🔍 Search Application");
            System.out.println("1. 📂 Browse Categories & Open App");
            System.out.println("2. ➕ Add Category");
            System.out.println("3. ➕ Add Application");
            System.out.println("4. ❌ Exit");
            System.out.println("=========================================");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 0:
                	System.out.println();
                    System.out.print("Enter app name to search: ");
                    String keyword = sc.nextLine();

                    service.searchApp(keyword);
                    System.out.println();
                    System.out.print("\nEnter App ID to Open ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    if (sid != 0)
                        service.openapp(sid);
                    break;

                case 1:
                    service.showcategories();
                    System.out.println();
                    System.out.print("Enter Category ID: ");
                    int cid = sc.nextInt();

                    service.showapps(cid);
                    System.out.println();
                    System.out.print("Enter App ID to open: ");
                    int aid = sc.nextInt();

                    service.openapp(aid);
                    break;

                case 2:
                	System.out.println();
                    System.out.print("Enter Category Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Emoji: ");
                    String cemoji = sc.nextLine();
                    service.addCategory(cname, cemoji);
                    break;

                case 3:
                    service.showcategories();
                    System.out.println();
                    System.out.print("Enter Category ID: ");
                    int catId = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    System.out.print("Enter App Name: ");
                    String aname = sc.nextLine();
                    System.out.print("Enter App Link: ");
                    String alink = sc.nextLine();
                    System.out.print("Enter Emoji: ");
                    String aemoji = sc.nextLine();

                    service.addApplication(catId, aname, alink, aemoji);
                    break;

                case 4:
                	System.out.println();
                    System.out.println(" Thank you for using AppHub!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
    }
}
