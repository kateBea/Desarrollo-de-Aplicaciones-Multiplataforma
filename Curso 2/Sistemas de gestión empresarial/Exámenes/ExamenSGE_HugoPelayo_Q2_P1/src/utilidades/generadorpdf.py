import pdfkit
import jinja2

class PDFTool:
    def __init__(self, templates_path):
        self.templates_path = templates_path
        
        self.template_loader = jinja2.FileSystemLoader(searchpath=self.templates_path)
        self.template_env = jinja2.Environment(loader=self.template_loader)
        
        print(f"Ubicación platillas {self.templates_path}")
    
    def render(self, data, template_name):
        EXEC_PATH = "/usr/bin/wkhtmltopdf"
        self.template = self.template_env.get_template( template_name )
        self.formatoWeb = self.template.render(data)
        self.config = pdfkit.configuration(wkhtmltopdf=EXEC_PATH)
    
    def generate_output(self, file_name):
        pdfkit.from_string(self.formatoWeb, file_name, configuration=self.config)