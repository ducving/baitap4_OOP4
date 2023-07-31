package bt2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class IPAddressAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập địa chỉ IP cần phân tích: ");
        String ipAddress = scanner.nextLine();

        if (isValidIPAddress(ipAddress)) {
            System.out.println("dia chi ip hop le");
        } else {
            System.out.println("Địa chỉ IP không hợp lệ!");
        }
    }

    public static boolean isValidIPAddress(String ipAddress) {
        String[] ipParts = ipAddress.split("\\.");

        if (ipParts.length != 4) {
            return false;
        }

        for (String part : ipParts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

}



