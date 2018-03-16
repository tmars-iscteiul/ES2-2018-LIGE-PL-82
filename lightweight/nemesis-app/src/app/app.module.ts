import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LFBootstrapThemeModule } from '@lightweightform/bootstrap-theme';
import { OtherServicesComponent } from './components/other-services/other-services.component';
import { AppService } from './services/app.service';
import { AddInputsComponent } from './components/add-inputs/add-inputs.component';
import { InputsTableComponent } from './components/add-inputs/inputs-table/inputs-table.component';
import { MainInformationComponent } from './components/main-information/main-information.component';
import { InputsComponent } from './components/inputs/inputs.component';
import { SystemInformationComponent } from './components/system-information/system-information.component';
import { IntrodutionComponent } from './components/introdution/introdution.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { CreateInputListComponent } from './components/inputs/components/create-input-list/create-input-list.component';
import { CreateInputItemsComponent } from './components/inputs/components/create-input-items/create-input-items.component';
import { OptimizationComponent } from './components/optimization/optimization.component';
import { FitnessAppComponent } from './components/fitness-app/fitness-app.component';

@NgModule({
  declarations: [
    AppComponent,
    OtherServicesComponent,
    AddInputsComponent,
    InputsTableComponent,
    MainInformationComponent,
    InputsComponent,
    SystemInformationComponent,
    IntrodutionComponent,
    FeedbackComponent,
    CreateInputListComponent,
    CreateInputItemsComponent,
    OptimizationComponent,
    FitnessAppComponent
  ],
  imports: [
    BrowserModule,
    LFBootstrapThemeModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule { }
