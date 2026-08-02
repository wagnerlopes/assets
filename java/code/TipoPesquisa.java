/* 
 * TipoPesquisa uma forma de encapusular a chamada de um método dentro de um Enum 
 * através de um LABEl passando os valores dos parâmetros usando Enum.
 */
package br.com.wagnersoft.macedonia.type;

import org.springframework.ui.Model;

import br.com.wagnersoft.macedonia.model.Beneficiario;
import br.com.wagnersoft.macedonia.service.BeneficiarioService;
import br.com.wagnersoft.macedonia.service.GuiaEncaminhamentoService;
import br.com.wagnersoft.macedonia.service.OcsService;
import br.com.wagnersoft.macedonia.service.ProfissionalService;

public enum TipoPesquisa {
  
  BENEFICIARIO("beneficiario") {
    @Override
    public String view(Model model, String nome,
                        BeneficiarioService benSvc,
                        OcsService ocsSvc,
                        ProfissionalService profSvc,
                        GuiaEncaminhamentoService guiaSvc) {
      model.addAttribute("allBeneficiarios", benSvc.findByNome(nome));
      model.addAttribute("beneficiario", new Beneficiario());
      return "beneficiarios";
    }
  },

  ESTABELECIMENTO("estabelecimento") {
    @Override
    public String view(Model model, String nome,
                        BeneficiarioService benSvc,
                        OcsService ocsSvc,
                        ProfissionalService profSvc,
                        GuiaEncaminhamentoService guiaSvc) {
      model.addAttribute("allOcs", ocsSvc.findByDescricao(nome));
      return "ocs";
    }
  },

  PROFISSIONAL("profissional") {
    @Override
    public String view(Model model, String nome,
                        BeneficiarioService benSvc,
                        OcsService ocsSvc,
                        ProfissionalService profSvc,
                        GuiaEncaminhamentoService guiaSvc) {
      model.addAttribute("allProfissionais", profSvc.findByNome(nome));
      return "profissionais";
    }
  },

  GUIA("guia") {
    @Override
    public String view(Model model, String nome,
                        BeneficiarioService benSvc,
                        OcsService ocsSvc,
                        ProfissionalService profSvc,
                        GuiaEncaminhamentoService guiaSvc) {
      model.addAttribute("allGuias", guiaSvc.findByGuiaNr(nome));
      return "guias";
    }
  };

  private final String formValue;

  TipoPesquisa(String formValue) {
    this.formValue = formValue;
  }

  public String formValue() {
    return formValue;
  }

  // Conversão segura do valor do form -> enum
  public static TipoPesquisa fromFormValue(String value) {
    for (TipoPesquisa t : values()) {
      if (t.formValue.equalsIgnoreCase(value)) return t;
    }
    throw new IllegalArgumentException("Pesquisa inválida: " + value);
  }

  public abstract String view(
      Model model,
      String nome,
      BeneficiarioService benSvc,
      OcsService ocsSvc,
      ProfissionalService profSvc,
      GuiaEncaminhamentoService guiaSvc
  );

}

/* Como chamar o tipoPesquisa no Controller:
 *
 * @PostMapping
 * public String searchEnum(@RequestParam("tipo") String tipo, @RequestParam("nome") String nome, Model model) {
 *   TipoPesquisa t = TipoPesquisa.fromFormValue(tipo);
 *   return t.view(model, nome, benSvc, ocsSvc, profSvc, guiaSvc);
 * }  
 */