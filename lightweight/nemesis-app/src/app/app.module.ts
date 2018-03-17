import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LFBootstrapThemeModule } from '@lightweightform/bootstrap-theme';
import { OtherServicesComponent } from './components/other-services/other-services.component';
import { AppService } from './services/app.service';
import { MainInformationComponent } from './components/main-information/main-information.component';
import { InputsComponent } from './components/inputs/inputs.component';
import { SystemInformationComponent } from './components/system-information/system-information.component';
import { IntrodutionComponent } from './components/introdution/introdution.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { CreateInputItemsComponent } from './components/inputs/components/create-input-items/create-input-items.component';
import { OptimizationComponent } from './components/optimization/optimization.component';
import { FitnessAppComponent } from './components/fitness-app/fitness-app.component';
import { InputListTableComponent } from './components/inputs/components/input-list-table/input-list-table.component';
import { FitnessTableComponent } from './components/fitness-app/components/fitness-table/fitness-table.component';
import { FaqsComponent } from './components/faqs/faqs.component';
import { InputsNameTableComponent } from './components/inputs/components/create-input-items/components/inputs-name-table/inputs-name-table.component';
import { RestrictionsComponent } from './components/inputs/components/restrictions/restrictions.component';
import { RestrictionsTableComponent } from './components/inputs/components/restrictions/components/restrictions-table/restrictions-table.component';

@NgModule({
  declarations: [
    AppComponent,
    OtherServicesComponent,
    MainInformationComponent,
    InputsComponent,
    SystemInformationComponent,
    IntrodutionComponent,
    FeedbackComponent,
    CreateInputItemsComponent,
    OptimizationComponent,
    FitnessAppComponent,
    InputListTableComponent,
    FitnessTableComponent,
    FaqsComponent,
    InputsNameTableComponent,
    RestrictionsComponent,
    RestrictionsTableComponent
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
