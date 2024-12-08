import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.locator('html').click();
  await page.goto('http://localhost:3000/consoles');
  await page.getByRole('row', { name: '6754d6aa036f7805ac5dd690 NES' }).getByRole('button').nth(1).click();
  await page.goto('http://localhost:3000/consoles');
});