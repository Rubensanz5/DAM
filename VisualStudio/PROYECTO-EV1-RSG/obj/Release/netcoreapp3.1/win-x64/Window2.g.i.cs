﻿#pragma checksum "..\..\..\..\Window2.xaml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "B3D25C6E1D456A5B70FEECC419DB4F8B6C5C29B3"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using PROYECTO_EV1_RSG;
using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Controls.Ribbon;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace PROYECTO_EV1_RSG {
    
    
    /// <summary>
    /// Window2
    /// </summary>
    public partial class Window2 : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 16 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.MenuItem salirmenu;
        
        #line default
        #line hidden
        
        
        #line 19 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Grid gridJuego;
        
        #line default
        #line hidden
        
        
        #line 20 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Image pt1;
        
        #line default
        #line hidden
        
        
        #line 21 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Image pt2;
        
        #line default
        #line hidden
        
        
        #line 22 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Image pt3;
        
        #line default
        #line hidden
        
        
        #line 24 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.RadioButton rdPuerta1;
        
        #line default
        #line hidden
        
        
        #line 25 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.RadioButton rdPuerta2;
        
        #line default
        #line hidden
        
        
        #line 26 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.RadioButton rdPuerta3;
        
        #line default
        #line hidden
        
        
        #line 28 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button btnComprobar;
        
        #line default
        #line hidden
        
        
        #line 31 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label lbPuntuacion;
        
        #line default
        #line hidden
        
        
        #line 35 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label lbVidas;
        
        #line default
        #line hidden
        
        
        #line 36 "..\..\..\..\Window2.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label lbvidasN;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "5.0.11.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/PROYECTO-EV1-RSG;component/window2.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\..\..\Window2.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "5.0.11.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.salirmenu = ((System.Windows.Controls.MenuItem)(target));
            
            #line 16 "..\..\..\..\Window2.xaml"
            this.salirmenu.Click += new System.Windows.RoutedEventHandler(this.volvermenu_Click);
            
            #line default
            #line hidden
            return;
            case 2:
            this.gridJuego = ((System.Windows.Controls.Grid)(target));
            return;
            case 3:
            this.pt1 = ((System.Windows.Controls.Image)(target));
            return;
            case 4:
            this.pt2 = ((System.Windows.Controls.Image)(target));
            return;
            case 5:
            this.pt3 = ((System.Windows.Controls.Image)(target));
            return;
            case 6:
            this.rdPuerta1 = ((System.Windows.Controls.RadioButton)(target));
            return;
            case 7:
            this.rdPuerta2 = ((System.Windows.Controls.RadioButton)(target));
            return;
            case 8:
            this.rdPuerta3 = ((System.Windows.Controls.RadioButton)(target));
            return;
            case 9:
            this.btnComprobar = ((System.Windows.Controls.Button)(target));
            
            #line 28 "..\..\..\..\Window2.xaml"
            this.btnComprobar.Click += new System.Windows.RoutedEventHandler(this.comprobar);
            
            #line default
            #line hidden
            return;
            case 10:
            this.lbPuntuacion = ((System.Windows.Controls.Label)(target));
            return;
            case 11:
            this.lbVidas = ((System.Windows.Controls.Label)(target));
            return;
            case 12:
            this.lbvidasN = ((System.Windows.Controls.Label)(target));
            return;
            }
            this._contentLoaded = true;
        }
    }
}
