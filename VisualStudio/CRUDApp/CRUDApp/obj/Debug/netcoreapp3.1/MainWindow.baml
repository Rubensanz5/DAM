   M S B A M L   `   `   `  ����B  >CRUDApp, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null!clr-namespace:CRUDAppCRUDApp  5   	       CRUDApp.MainWindow   5   	   W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   'localclr-namespace:CRUDApp     5   	     � Title$  Información de Producto��5   	   $	��650��6)   $	��800��66   .��5	      � .+�5
   
   �� $��Código Producto:��6   $
��Left=�6+   $��
116,32,0,0q�6F   $	��Top=�6Z   $��20(�6r   �� 5   
   -   5         ��Name$ txtCodProducto��5      $
��Left=�6*   $��
304,32,0,0q�6E    �� TextWrapping$
 Wrap=�6Y   $	��Top=�5      $	��225��6*   $��38��66   $��20(�6B   �� 5   
   -   5         ��Name$ 	btnBuscar��5      $��Buscar��6$   $
��Left=�65   $��
544,36,0,0q�6P   $	��Top=�5      $��20(�6%   $��94��63   6>   �� 5   
   -   5        $ txtIdProducto��5      $
��Left=�6)   $��
656,34,0,0q�6D   $
 Wrap=�6X   $	��Top=�5      $��94��6%   $��38��60   $��20(�6<   $y�Hidden=�6J   �� 5   
   $��Nombre:��6   $
��Left=�6"   $��
193,86,0,0q�6=   $	��Top=�6Q   $��20(�6i   �� 5   
   -   5        $ 	txtNombre��5      $
��Left=�6%   $��
304,86,0,0q�6@   $
 Wrap=�6T   $	��Top=�5      $	��334��6*   $��38��66   $��20(�6B   �� 5   
   $��Descripcion:��6   $
��Left=�6'   $��163,142,0,0q�6B   $	��Top=�6W   $��20(�6o   �� 5   
   -   5        $ txtDescripcion��5      $
��Left=�6*   $��304,142,0,0q�6E   $
 Wrap=�6Z   $	��Top=�5      $	��334��6*   $	��175��66   $��20(�6C    �� AcceptsReturn$
 True��5      " �� VerticalScrollBarVisibility$ Visible=�6)   �� 5   
   $��Precio:��6   $
��Left=�6"   $��212,362,0,0q�6=   $	��Top=�6R   $��20(�6j   �� 5   
   -   5        $ 	txtPrecio��5      $��Center=�6%   $��	0,362,0,0q�6B   $
 Wrap=�6U   $	��Top=�5      $	��135��6*   $��38��66   $��20(�6B   �� 5   
   $��Existencias:��6   $
��Left=�6'   $��172,455,0,0q�6B   $	��Top=�6W   $��20(�6o   �� 5   
   -   5        $ txtExistencias��5      $��Center=�6*   $��	0,454,0,0q�6G   $	��Top=�5      $	��135��6.   $��20(�6:   $��38��6H   �� 5   
   -   5        $ 
btnGuardar��5      $��Guardar��6%   $
��Left=�67   $��
41,536,0,0q�6R   $	��Top=�5      $��20(�6)   $	��159��67   6C   �� 5    
   -	   5        $ btnActualizar��5       $��
Actualizar��6(   $
��Left=�6=   $��231,536,0,0q�6X   $	��Top=�5!      $��20(�6)   $	��159��67   6C   �� 5"   
   -
   5        $ btnEliminar��5"      $��Eliminar��6&   $
��Left=�69   $��422,536,0,0q�6T   $	��Top=�5#      $��20(�6)   $	��159��67   6C   �� 5$   
   -   5        $ 
btnLimpiar��5$      $��Limpiar��6%   $
��Left=�67   $��612,536,0,0q�6R   $	��Top=�5%      $��20(�6)   $	��159��67   6C   5&      5'      