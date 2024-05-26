package servico;

import java.util.Scanner;
import entidades.Hotel;
import dao.HotelDao;

public class ServicoHotel {

    public void cadastrarHotel() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite CNPJ do Hotel: ");
        String cnpj = sc.nextLine();
        System.out.println("Digite nome do Hotel");
        String nome = sc.nextLine();
        System.out.println("Agora vamos cadastrar os dados do endereço do Hotel!\n");
        System.out.println("Digite a rua do Hotel: ");
        String rua = sc.nextLine();
        System.out.println("Digite o bairro do Hotel: ");
        String bairro = sc.nextLine();
        System.out.println("Digite o CEP do Hotel: ");
        String cep = sc.nextLine();
        System.out.println("Digite o complemento do Hotel: ");
        String complemento = sc.nextLine();
        System.out.println("Digite o estado do Hotel: ");
        String estado = sc.nextLine();

        Hotel h = new Hotel();
        h.setCnpj(cnpj);
        h.setNome(nome);
        h.setRua(rua);
        h.setBairro(bairro);
        h.setCep(cep);
        h.setComplemento(complemento);
        h.setEstado(estado);

        new HotelDao().cadastrarHotel(h);

        System.out.println("Hotel cadastrado com sucesso!");

        sc.close();
    }
}
