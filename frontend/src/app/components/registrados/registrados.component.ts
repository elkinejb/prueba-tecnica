import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-registrados',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './registrados.component.html',
  styleUrls: ['./registrados.component.css'] // ✅ CORRECTO
})
export class RegistradosComponent implements OnInit {
  productos: any[] = [];

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.productos = this.dataService.obtenerProductos();
  }
}
