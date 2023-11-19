import java.util.Random;

import java.util.Scanner;

 

public class App {

    static Scanner in = new Scanner(System.in);

    static Random rand=new Random();

    static final String verde =   "\u001B[1;32m";
    static final String amarelo = "\u001B[1;33m";
    static final String reset =   "\u001B[0m";
    static final String bold =    "\u001B[1;37m";
    static final String azul=     "\u001B[1;36m";
    static final String vermelho= "\u001B[1;31m";
    static final String roxo =    "\u001B[1;95m";

    

    public static void main(String[] args) {

        String[] words=new String[] {"sagaz", "amago", "negro", "termo", "exito", "mexer", "nobre", "senso", "afeto", "algoz", "etica", "plena", "mutua", "tenue", "fazer", "assim", "vigor", "sutil", "aquem", "porem", "secao", "fosse", "sanar", "poder", "audaz", "ideia", "cerne", "inato", "sobre", "desde", "muito", "moral", "justo", "honra", "quica", "sonho", "razao", "futil", "etnia", "icone", "anexo", "amigo", "tange", "lapso", "haver", "expor", "mutuo", "dengo", "tempo", "casal", "entao", "habil", "seara", "bocal", "avido", "ardil", "pesar", "saber", "causa", "graca", "dizer", "genro", "obice", "posse", "coser", "paria", "dever", "brado", "tenaz", "prole", "sendo", "crivo", "corja", "comum", "temor", "detem", "ainda", "animo", "apice", "ceder", "ansia", "estar", "digno", "pauta", "assaz", "xibiu", "culto", "mundo", "atroz", "fugaz", "censo", "gleba", "forte", "vicio", "vulgo", "cozer", "valha", "denso", "nenem", "orelha"} ;
        //System.out.println(words.length);
        int qtdTentativas;
        
        System.out.println(bold+"-- Jogo do Termo -- \nBem-Vindo!\n"+reset+"O objetivo é descobrir qual é a palavra oculta");
        //rules
        do {
        	System.out.println(bold+"Regras: \n"+reset
        			+ "1.Todas as palavras terão 5 caracteres\n"
        			+ "2.As letras"+verde+" verdes "+reset+"estão na posição correta\n"
        			+ "3.As letras"+amarelo+" amarelas "+reset+"estão na posição errada, porém, pertencem a palavra oculta\n"
        			+ "4.As letras sem alteração de cor não pertencem a palavra oculta\n");

        	System.out.println("Você está preparado?"+azul+" Sim "+reset+"ou"+vermelho+" Não "+reset);
        	System.out.print(roxo);
			String ready=acento(in.nextLine().toUpperCase());
			
			if (!ready.equals("NAO") && !ready.equals("SIM")) {
				
				System.err.println("Opção Inválida!");
				continue;
			} else if(ready.equals("NAO")) {
				continue;
			}else {
				break;
			}
		} while (true);
        
        
        
        //Escolha de dificuldade
        do {
        	System.out.println(bold+"Escolha uma Dificuldade:\n"+reset
        			+ "1.Facil   ( 9 tentativas )\n"
        			+ "2.Normal  ( 6 tentativas )\n"
        			+ "3.Dificil ( 3 tentativas )");
        	System.out.print(roxo);
        	int dific=in.nextInt();

        	if (dific<1 || dific>3) {

				System.err.println("Opção Inválida!");

				continue;

			} else if(dific==1) {

				qtdTentativas=9;

				break;

			}else if(dific==2) {

				qtdTentativas=6;

				break;

			}else if(dific==3) {

				qtdTentativas=3;

				break;

			}

		} while (true);

        

        boolean sit;
        boolean rep;
        do {
        	
        	int pos=rand.nextInt(0,words.length);
            String oculta=words[pos].toUpperCase();
			sit=verificar(oculta,qtdTentativas);

			

			if (sit) {

				System.out.println(bold+"Parabens!! \nVocê acertou a palavra oculta."+reset);

			} else {

				System.out.println(bold+"Infelizmente, você não acertou a palavra oculta."+reset);

		        System.out.println("A palavra oculta era: "+verde+oculta+reset);

			}

			

			do {
				
				System.out.println(bold+"Quer jogar de novo? "+azul+"Sim "+reset+"ou"+vermelho+" Não"+reset);
				System.out.print(roxo);
				String restart=acento(in.next()).toUpperCase();
				System.out.print(reset);
				if (!restart.equals("NAO") && !restart.equals("SIM")) {
					
					System.err.println("Opção Inválida!");
					continue;
				} else if(restart.equals("NAO")) {
					System.out.println(bold+"Obrigado por jogar"+reset);
					System.out.println(bold+
							 "      ▄▀▄     ▄▀▄\n"
							+"     ▄█░░▀▀▀▀▀░░█▄\n"
							+" ▄▄  █░░░░░░░░░░░█  ▄▄\n"
							+"█▄▄█ █░░▀░░┬░░▀░░█ █▄▄█"
							+reset);
					rep=false;
					break;
				}else {

					rep=true;
					break;
				}

			} while (true);

		} while (rep);

    }

 
    
    public static boolean verificar(String oculta,int qtdTentativas){
        boolean situacao=true;
        String[] words=new String[qtdTentativas];
        
        for (int i = 0; i < words.length; i++) {
			words[i]=bold+(i+1)+" - ";
		}
        
        for (int i = 0; i <= qtdTentativas; i++) {
            if(i==qtdTentativas){
                situacao=false;
                break;
            }

            System.out.println(azul+oculta+reset);
            System.out.println(bold+"Informe uma palavra: ");
            System.out.print(roxo);
            words[i]= in.next().toUpperCase();
            System.out.print(reset);
            while(words[i].length()!=5) {
            	System.err.println("Quantidade de caracteres invalida");
                words[i] = in.next().toUpperCase();
            }                	
            words[i]=acento(words[i]);
                
            if (words[i].equals(oculta)) {

                situacao= true;
                break;
            } else {
                String[] wor = new String[5];
                

                for (int j = 0; j < wor.length; j++) {
                    wor[j] = "" + words[i].charAt(j);
                }
               
                for (int c1=0;c1<wor.length;c1++) {

                    if (wor[c1].equals(""+oculta.charAt(c1))) {

                        wor[c1]=verde + wor[c1] + reset;

                    } else if (oculta.contains(wor[c1]) && !wor[c1].equals(""+oculta.charAt(c1))) {

                    	wor[c1]=amarelo + wor[c1] + reset;

                    } else {

                    	continue;
                    }

                }
                words[i]=bold+(i+1)+" - ";
                for (String x : wor ) {
					words[i]=words[i]+x;
				}
                
                for (int j = 0; j < words.length; j++) {
						System.out.println(words[j]);
				}
				
            }

        }

        return situacao;
    }

    

    public static String acento(String word) {

    	String[] wor=new String[word.length()];

    	String palavra="";

    	for (int i = 0; i < wor.length; i++) {
    		//System.out.println(i);
    		
			wor[i]=""+word.charAt(i);
			wor[i]=wor[i].toUpperCase();

			if (wor[i].equals("Í") || wor[i].equals("Ì") || wor[i].equals("Î")) {

				wor[i]="I";

			} else if(wor[i].equals("Á") || wor[i].equals("À" ) || wor[i].equals("Â" ) || wor[i].equals("Ã" )) {
				wor[i]="A";

			}else if(wor[i].equals("Ó" ) || wor[i].equals("Ò" ) || wor[i].equals("Ô" ) || wor[i].equals("Õ" )) {

				wor[i]="O";

			}else if(wor[i].equals("É" ) || wor[i].equals("È" ) || wor[i].equals("Ê" )) {

				wor[i]="E";

			}else if(wor[i].equals("Ú" ) || wor[i].equals("Ù" ) || wor[i].equals("Û" )) {

				wor[i]="U";

			}

		}

    	for (String string : wor) {

			palavra=""+palavra+string;

		}
    	return palavra;

    }

 

 

}